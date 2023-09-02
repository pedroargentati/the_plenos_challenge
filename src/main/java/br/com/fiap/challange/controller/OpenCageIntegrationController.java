package br.com.fiap.challange.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.challange.constants.Endpoints;
import br.com.fiap.challange.integrations.OpencageIntegration;
import br.com.fiap.challange.model.OpencageIntegrationModel;

@RestController
public class OpenCageIntegrationController {

	@SuppressWarnings("unchecked")
	@GetMapping(Endpoints.OPEN_CAGE_INTEGRATION)
	public ResponseEntity<OpencageIntegrationModel> makeIntegration(@RequestParam String q) {
		if (!q.contains(",")) {
			return (ResponseEntity<OpencageIntegrationModel>) ResponseEntity.badRequest();
		}

		String[] coords = q.split(",");
		Double latitude = Double.valueOf(coords[0]);
		Double longitude = Double.valueOf(coords[1]);
		
		System.out.println("oiii");
		OpencageIntegrationModel response = OpencageIntegration.makeIntegration(latitude, longitude);
		return ResponseEntity.ok(response);
		
	}
	
}
