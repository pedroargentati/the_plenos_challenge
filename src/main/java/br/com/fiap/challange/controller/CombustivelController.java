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
import br.com.fiap.challange.entity.CombustivelEntity;
import br.com.fiap.challange.repository.CombustivelRepository;

@RestController
public class CombustivelController {

	@Autowired
	private CombustivelRepository combustivelRepository;

	@GetMapping(Endpoints.COMBUSTIVEL)
	public ResponseEntity<List<CombustivelEntity>> findAll() {

		var combustivelList = combustivelRepository.findAll();

		return ResponseEntity.ok(combustivelList);
	}

	@PostMapping(Endpoints.REGISTER_COMBUSTIVEL)
	public ResponseEntity<CombustivelEntity> create(@RequestBody CombustivelEntity model) {

		combustivelRepository.save(model);

		return new ResponseEntity<>(model, HttpStatus.OK);
	}

}
