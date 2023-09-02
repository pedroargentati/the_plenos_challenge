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
import br.com.fiap.challange.repository.ClienteRepository;

@RestController
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping(Endpoints.GET_ALL_CLIENTS)
	public ResponseEntity<List<ClienteEntity>> findAll() {

		var clients = clienteRepository.findAll();

		return ResponseEntity.ok(clients);
	}

	@PostMapping(Endpoints.REGISTER_CLIENTS)
	public ResponseEntity<ClienteEntity> create(@RequestBody ClienteEntity model) {

		clienteRepository.save(model);

		return new ResponseEntity<>(model, HttpStatus.OK);
	}

}
