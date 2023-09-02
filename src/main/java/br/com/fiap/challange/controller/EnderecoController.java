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
import br.com.fiap.challange.entity.EnderecoEntity;
import br.com.fiap.challange.repository.EnderecoRepository;

@RestController
public class EnderecoController {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@GetMapping(Endpoints.GET_ALL_ADDRESS)
	public ResponseEntity<List<EnderecoEntity>> findAll() {

		var supply = enderecoRepository.findAll();

		return ResponseEntity.ok(supply);
	}

	@PostMapping(Endpoints.REGISTER_ADDRESS)
	public ResponseEntity<EnderecoEntity> create(@RequestBody EnderecoEntity model) {

		enderecoRepository.save(model);

		return new ResponseEntity<>(model, HttpStatus.OK);
	}

}
