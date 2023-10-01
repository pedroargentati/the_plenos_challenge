package br.com.fiap.challange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.challange.constants.Endpoints;
import br.com.fiap.challange.entity.AbastecimentoEntity;
import br.com.fiap.challange.entity.EnderecoEntity;
import br.com.fiap.challange.entity.StatusCombustivelEntity;
import br.com.fiap.challange.exeptions.ChallangeException;
import br.com.fiap.challange.exeptions.IntegrationException;
import br.com.fiap.challange.integrations.OpencageIntegration;
import br.com.fiap.challange.model.CoordinatesModel;
import br.com.fiap.challange.model.OpencageDTOPOST;
import br.com.fiap.challange.model.OpencageIntegrationModel;
import br.com.fiap.challange.repository.AbastecimentoRepository;
import br.com.fiap.challange.repository.EnderecoRepository;
import br.com.fiap.challange.repository.StatusCombustivelRepository;
import br.com.fiap.challange.services.ConversionService;
import jakarta.validation.Valid;

@RestController
public class OpenCageIntegrationController {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private AbastecimentoRepository abastecimentoRepository;

	@Autowired
	private StatusCombustivelRepository statusCombustivelRepository;

	/**
	 * Endpoint para integrar com o serviço OpenCage a partir das coordenadas fornecidas.
	 *
	 * @param coordinates Coordenadas no formato "latitude,longitude" (por exemplo, "12.34,56.78").
	 * @return Detalhes da integração OpenCage.
	 * @throws IntegrationException Se ocorrer um erro durante a integração.
	 */
	@GetMapping(Endpoints.OPEN_CAGE_INTEGRATION)
	public ResponseEntity<OpencageIntegrationModel> makeIntegration(@RequestParam String coordinates)
			throws IntegrationException {
		String[] coords = coordinates.split(",");

		if (coords.length != 2) {
			return ResponseEntity.badRequest().build();
		}

		try {
			Double latitude = Double.parseDouble(coords[0]);
			Double longitude = Double.parseDouble(coords[1]);

			OpencageIntegrationModel response = OpencageIntegration.makeIntegration(latitude, longitude);
			return ResponseEntity.ok(response);
		} catch (NumberFormatException e) {
			return ResponseEntity.badRequest().build();
		}
	}

	/**
	 * Endpoint para registrar um endereço por meio da integração com o serviço OpenCage.
	 *
	 * @param coords Coordenadas no formato de um objeto JSON contendo latitude e longitude.
	 * @return Detalhes do endereço e informações adicionais.
	 * @throws ChallangeException Se ocorrer um erro durante o processo de registro ou integração.
	 */
	@PostMapping(Endpoints.REGISTER_OPEN_CAGE_INTEGRATION)
	public ResponseEntity<OpencageDTOPOST> adicionaEnderecoPorIntegracao(@RequestBody @Valid CoordinatesModel coords) throws ChallangeException {
		OpencageIntegrationModel response = OpencageIntegration.makeIntegration(coords.getLatitudade(), coords.getLongitude());

		if (response == null) {
			throw new IntegrationException(
					"[ERRO DE INTEGRAÇÃO] - Nenhum registro foi encontrado para essas coordenadas.",
					"(prepareResponse)",
					500);
		}

		EnderecoEntity endereco = ConversionService.mapOpencageResponseToEnderecoEntity(response);

		EnderecoEntity savedEndereco = enderecoRepository.save(endereco);

		if (savedEndereco != null) {
			AbastecimentoEntity abastecimento = ConversionService.mapOpencageResponseToAbastecimentoEntity(response, savedEndereco);
			
			StatusCombustivelEntity statusCombustivel = new StatusCombustivelEntity();
			
			StatusCombustivelEntity statusCombustivelSaved = null;
			statusCombustivel.setTipoCombustivelId(abastecimento.getTipoCombustivelId());
			
			Long randomNumber = ConversionService.getRandomValue();
			String qualidadeCombustivel = ConversionService.getGasQuality(randomNumber);
			
			statusCombustivel.setQualidade(qualidadeCombustivel);
			statusCombustivelSaved = statusCombustivelRepository.save(statusCombustivel);
			
			abastecimento.setStatusCombustivelId(statusCombustivelSaved.getStatusCombustivelId());
			AbastecimentoEntity savedAbastecimento = abastecimentoRepository.save(abastecimento);

			if (savedAbastecimento != null) {
				OpencageDTOPOST responseAPI = ConversionService.convertToOpencageDTO(savedAbastecimento, savedEndereco);
				if (statusCombustivelSaved != null) {
					responseAPI.setStatusCombustivelId(statusCombustivelSaved.getStatusCombustivelId());					
				}
				
				return ResponseEntity.status(HttpStatus.CREATED).body(responseAPI);
			}

		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

}
