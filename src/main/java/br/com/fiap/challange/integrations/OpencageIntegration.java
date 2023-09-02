package br.com.fiap.challange.integrations;

import java.util.List;

import com.byteowls.jopencage.JOpenCageGeocoder;
import com.byteowls.jopencage.model.JOpenCageResponse;
import com.byteowls.jopencage.model.JOpenCageResult;
import com.byteowls.jopencage.model.JOpenCageReverseRequest;

import br.com.fiap.challange.model.OpencageIntegrationModel;

public class OpencageIntegration {
	
	public static final String API_KEY = "91c4f0a5aafc407bb4576f286d507dc7";

	public static OpencageIntegrationModel makeIntegration(Double latitude, Double longitude) {
		JOpenCageGeocoder jOpenCageGeocoder = new JOpenCageGeocoder(API_KEY);
		System.out.println(jOpenCageGeocoder);

		JOpenCageReverseRequest request = new JOpenCageReverseRequest(latitude, longitude);
		System.out.println(request);

		JOpenCageResponse response = jOpenCageGeocoder.reverse(request);

		// get the formatted address of the first result:
		// String formattedAddress = response.getResults().get(0).getFormatted();
		// formattedAddress is now 'Travessera de Gràcia, 142, 08012 Barcelona, España'
		
		OpencageIntegrationModel openCageResponseFormatted = prepareResponse(response);
		
		return openCageResponseFormatted;
	}
	
	private static OpencageIntegrationModel prepareResponse(JOpenCageResponse response) {
		OpencageIntegrationModel opencageIntegrationModel = new OpencageIntegrationModel();
		
		List<JOpenCageResult> results = response.getResults();
		if (results.size() == 1) {
			JOpenCageResult jOpenResult = results.get(0);
			
			opencageIntegrationModel.setLat(jOpenResult.getGeometry().getLat());
			opencageIntegrationModel.setLng(jOpenResult.getGeometry().getLng());
			opencageIntegrationModel.setType(jOpenResult.getComponents().getType());
			opencageIntegrationModel.setContinent(jOpenResult.getComponents().getContinent());
			opencageIntegrationModel.setCity(jOpenResult.getComponents().getCity());
			opencageIntegrationModel.setCounty(jOpenResult.getComponents().getCountry());
			opencageIntegrationModel.setAddress(jOpenResult.getFormatted());

		} else {
			results.forEach((jOpenResult) -> {
				OpencageIntegrationModel openCageItem = new OpencageIntegrationModel();
				
				openCageItem.setLat(jOpenResult.getGeometry().getLat());
				openCageItem.setLng(jOpenResult.getGeometry().getLng());
				openCageItem.setType(jOpenResult.getComponents().getType());
				openCageItem.setContinent(jOpenResult.getComponents().getContinent());
				openCageItem.setCity(jOpenResult.getComponents().getCity());
				openCageItem.setCounty(jOpenResult.getComponents().getCountry());
				openCageItem.setAddress(jOpenResult.getFormatted());
				
				opencageIntegrationModel.getResponseList().add(opencageIntegrationModel);
			});
		}
		
		return opencageIntegrationModel;
		
	}

}
