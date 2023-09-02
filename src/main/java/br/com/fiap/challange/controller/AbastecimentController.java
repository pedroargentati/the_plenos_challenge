package br.com.fiap.challange.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.challange.constants.Endpoints;
import br.com.fiap.challange.entity.AbastecimentoEntity;
import br.com.fiap.challange.repository.AbastecimentoRepository;

@RestController
public class AbastecimentController {

	@Autowired
	private AbastecimentoRepository abastecimentoRepository;

	@GetMapping(Endpoints.GET_SUPPLY)
	public ResponseEntity<List<AbastecimentoEntity>> findAll() {

		var supply = abastecimentoRepository.findAll();

		return ResponseEntity.ok(supply);
	}
	
	@PostMapping(Endpoints.REGISTER_ABASTECIMENTO)
	public ResponseEntity<AbastecimentoEntity> create(@RequestBody AbastecimentoEntity model) {

		abastecimentoRepository.save(model);

		return new ResponseEntity<>(model, HttpStatus.OK);
	}

}
