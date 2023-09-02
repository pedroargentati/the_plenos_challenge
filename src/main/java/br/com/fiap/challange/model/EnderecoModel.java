package br.com.fiap.challange.model;

public class EnderecoModel {

	private Integer enderecoid;
	private String rua;
	private String bairro;
	private String cidade;
	private String pais;
	private String continente;
	private String tipoLugar;

	public Integer getEnderecoid() {
		return enderecoid;
	}

	public void setEnderecoid(Integer enderecoid) {
		this.enderecoid = enderecoid;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getContinente() {
		return continente;
	}

	public void setContinente(String continente) {
		this.continente = continente;
	}

	public String getTipoLugar() {
		return tipoLugar;
	}

	public void setTipoLugar(String tipoLugar) {
		this.tipoLugar = tipoLugar;
	}

}
