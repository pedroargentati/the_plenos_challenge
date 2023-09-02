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
import br.com.fiap.challange.entity.ClienteEntity;
import br.com.fiap.challange.entity.TipoCombustivelEntity;
import br.com.fiap.challange.repository.TipoCombustivelRepository;

@RestController
public class TipoCombustivelController {
	
	@Autowired
	private TipoCombustivelRepository tipoCombustivelRepository;
	
	@GetMapping(Endpoints.GET_ALL_TYPES)
	public ResponseEntity<List<TipoCombustivelEntity>> findAll() {

		var clients = tipoCombustivelRepository.findAll();

		return ResponseEntity.ok(clients);
	}

	@PostMapping(Endpoints.REGISTER_TYPE_FUEL)
	public ResponseEntity<TipoCombustivelEntity> create(@RequestBody TipoCombustivelEntity model) {

		tipoCombustivelRepository.save(model);

		return new ResponseEntity<>(model, HttpStatus.OK);
	}
	
}
