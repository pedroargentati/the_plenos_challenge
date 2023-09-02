package br.com.fiap.challange.model;

import java.io.Serializable;
import java.util.List;

public class OpencageIntegrationModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<OpencageIntegrationModel> responseList;
	private Double lat; // GeoMetry
	private Double lng; // GeoMetry
	private String coordenates;
	private String type; // Components
	private String category; // Components
	private String continent; // Components
	private String city; // Components
	private String county; // Components
	private String address; // Components

	public List<OpencageIntegrationModel> getResponseList() {
		return responseList;
	}

	public void setResponseList(List<OpencageIntegrationModel> responseList) {
		this.responseList = responseList;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}
	
	public String getCoordinates() {
	    if (this.lat != null && this.lng != null) {
	        return  this.lat.toString().concat(", ").concat(this.lng.toString());
	    } else {
	    	return null;
	    }
	}

	public void setCoordenates(String coordenates) {
		this.coordenates = coordenates;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
