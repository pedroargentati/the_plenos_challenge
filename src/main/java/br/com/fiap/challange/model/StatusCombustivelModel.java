package br.com.fiap.challange.model;

public class StatusCombustivelModel {

	private Integer statusCombustivelId;
	private Integer tipoCombustivelId;
	private String combustivelAdulterado;

	public Integer getStatusCombustivelId() {
		return statusCombustivelId;
	}

	public void setStatusCombustivelId(Integer statusCombustivelId) {
		this.statusCombustivelId = statusCombustivelId;
	}

	public Integer getTipoCombustivelId() {
		return tipoCombustivelId;
	}

	public void setTipoCombustivelId(Integer tipoCombustivelId) {
		this.tipoCombustivelId = tipoCombustivelId;
	}

	public String getCombustivelAdulterado() {
		return combustivelAdulterado;
	}

	public void setCombustivelAdulterado(String combustivelAdulterado) {
		this.combustivelAdulterado = combustivelAdulterado;
	}

}
