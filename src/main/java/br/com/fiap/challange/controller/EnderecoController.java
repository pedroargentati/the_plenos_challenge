package br.com.fiap.challange.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.challange.constants.Endpoints;
import br.com.fiap.challange.entity.AbastecimentoEntity;
import br.com.fiap.challange.entity.EnderecoEntity;
import br.com.fiap.challange.model.OpencageDTOPOST;
import br.com.fiap.challange.repository.AbastecimentoRepository;
import br.com.fiap.challange.repository.EnderecoRepository;
import br.com.fiap.challange.services.ConversionService;

@RestController
public class EnderecoController {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private AbastecimentoRepository abastecimentoRepository;
	
	@GetMapping(Endpoints.GET_ALL_ADDRESS)
	public ResponseEntity<List<OpencageDTOPOST>> findAll() {
		List<EnderecoEntity> addres = enderecoRepository.findAll();
		List<AbastecimentoEntity> abastecimentos = abastecimentoRepository.findAll();

		// Mapeamento dos abastecimentos por enderecoId
		Map<Integer, List<AbastecimentoEntity>> abastecimentosPorEndereco = abastecimentos.stream()
				.collect(Collectors.groupingBy(AbastecimentoEntity::getEnderecoId));

		List<OpencageDTOPOST> responseList = addres.stream().map(endereco -> {
			List<AbastecimentoEntity> abastecimentoList = abastecimentosPorEndereco.get(endereco.getEnderecoId());
			if (abastecimentoList != null) {
				return abastecimentoList.stream()
						.map(abastecimento -> ConversionService.convertToOpencageDTO(abastecimento, endereco))
						.collect(Collectors.toList());
			}
			return Collections.<OpencageDTOPOST>emptyList();
		}).flatMap(Collection::stream).collect(Collectors.toList());

		return ResponseEntity.ok(responseList);
	}

	@PostMapping(Endpoints.REGISTER_ADDRESS)
	public ResponseEntity<EnderecoEntity> create(@RequestBody EnderecoEntity model) {

		enderecoRepository.save(model);

		return new ResponseEntity<>(model, HttpStatus.OK);
	}

}
