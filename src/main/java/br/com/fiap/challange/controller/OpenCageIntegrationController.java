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
import br.com.fiap.challange.entity.EnderecoEntity;
import br.com.fiap.challange.exeptions.IntegrationException;
import br.com.fiap.challange.integrations.OpencageIntegration;
import br.com.fiap.challange.model.CoordinatesModel;
import br.com.fiap.challange.model.OpencageIntegrationModel;
import br.com.fiap.challange.repository.EnderecoRepository;
import jakarta.validation.Valid;

@RestController
public class OpenCageIntegrationController {
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	@GetMapping(Endpoints.OPEN_CAGE_INTEGRATION)
	public ResponseEntity<OpencageIntegrationModel> makeIntegration(@RequestParam String coordinates) throws IntegrationException {
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
	
	@PostMapping(Endpoints.REGISTER_OPEN_CAGE_INTEGRATION)
	public ResponseEntity<EnderecoEntity> adicionaEnderecoPorIntegracao(@RequestBody @Valid CoordinatesModel coords) throws IntegrationException {
	    OpencageIntegrationModel response = OpencageIntegration.makeIntegration(coords.getLatitudade(), coords.getLongitude());

	    if (response == null) {
	        throw new IntegrationException("[ERRO DE INTEGRAÇÃO] - Nenhum registro foi encontrado para essas coordenadas.", "(prepareResponse)", 500);
	    }

	    EnderecoEntity endereco = this.mapOpencageResponseToEnderecoEntity(response);

	    EnderecoEntity savedEndereco = enderecoRepository.save(endereco);

	    if (savedEndereco != null) {
	        return ResponseEntity.status(HttpStatus.CREATED).body(savedEndereco);
	    } else {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}

	private EnderecoEntity mapOpencageResponseToEnderecoEntity(OpencageIntegrationModel response) {
	    EnderecoEntity endereco = new EnderecoEntity();
	    endereco.setRua(response.getRua());
	    endereco.setBairro(response.getBairro());
	    endereco.setCidade(response.getCity());
	    endereco.setPais(response.getCounty());
	    endereco.setContinente(response.getContinent());
	    endereco.setTipoLugar(response.getType().equalsIgnoreCase("fuel") ? "Posto de gasolina" : response.getType());
	    endereco.setCep(response.getCep());
	    return endereco;
	}

	
}
