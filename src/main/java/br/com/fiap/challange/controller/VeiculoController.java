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
import br.com.fiap.challange.entity.VeiculoEntity;
import br.com.fiap.challange.repository.VeiculoRepository;

@RestController
public class VeiculoController {

	@Autowired
	private VeiculoRepository veiculoRepository;

	@GetMapping(Endpoints.GET_ALL_VEICLES)
	public ResponseEntity<List<VeiculoEntity>> findAll() {

		var clients = veiculoRepository.findAll();

		return ResponseEntity.ok(clients);
	}

	@PostMapping(Endpoints.REGISTER_VEICLES)
	public ResponseEntity<VeiculoEntity> create(@RequestBody VeiculoEntity model) {

		veiculoRepository.save(model);

		return new ResponseEntity<>(model, HttpStatus.OK);
	}

}
