package br.com.fiap.challange.integrations;

import java.util.List;

import com.byteowls.jopencage.JOpenCageGeocoder;
import com.byteowls.jopencage.model.JOpenCageResponse;
import com.byteowls.jopencage.model.JOpenCageResult;
import com.byteowls.jopencage.model.JOpenCageReverseRequest;

import br.com.fiap.challange.exeptions.IntegrationException;
import br.com.fiap.challange.model.OpencageIntegrationModel;

public class OpencageIntegration {
	
	public static final String API_KEY = "91c4f0a5aafc407bb4576f286d507dc7";

	public static OpencageIntegrationModel makeIntegration(Double latitude, Double longitude) throws IntegrationException {
		JOpenCageGeocoder jOpenCageGeocoder = new JOpenCageGeocoder(API_KEY);

		JOpenCageReverseRequest request = new JOpenCageReverseRequest(latitude, longitude);

		JOpenCageResponse response = jOpenCageGeocoder.reverse(request);

		OpencageIntegrationModel openCageResponseFormatted = prepareResponse(response);
		
		return openCageResponseFormatted;
	}
	
	private static OpencageIntegrationModel prepareResponse(JOpenCageResponse response) throws IntegrationException {
		OpencageIntegrationModel opencageIntegrationModel = new OpencageIntegrationModel();
		
		List<JOpenCageResult> results = response.getResults();
		if (results != null && !results.isEmpty()) {
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
		} else {
			throw new IntegrationException("[ERRO DE INTEGRAÇÃO] - Nenhum registro foi encontrado para essas coordenadas.", "(prepareResponse)", 500);
		}
		
		return opencageIntegrationModel;
		
	}

}
