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

	@GetMapping(Endpoints.OPEN_CAGE_INTEGRATION)
	public ResponseEntity<OpencageIntegrationModel> makeIntegration(@RequestParam String coordinates) {
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

	
}
