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
import br.com.fiap.challange.entity.StatusCombustivelEntity;
import br.com.fiap.challange.repository.StatusCombustivelRepository;

@RestController
public class StatusController {
	
	
	@Autowired
	private StatusCombustivelRepository statusCombustivelRepository;
	
	@GetMapping(Endpoints.GET_ALL_STATUS)
	public ResponseEntity<List<StatusCombustivelEntity>> findAll() {

		var status = statusCombustivelRepository.findAll();

		return ResponseEntity.ok(status);
	}
	
	@PostMapping(Endpoints.REGISTER_STATUS)
	public ResponseEntity<StatusCombustivelEntity> create(@RequestBody StatusCombustivelEntity model) {

		statusCombustivelRepository.save(model);

		return new ResponseEntity<>(model, HttpStatus.OK);
	}
	
	
	
}
