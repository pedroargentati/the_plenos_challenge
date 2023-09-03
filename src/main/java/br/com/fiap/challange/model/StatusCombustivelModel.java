package br.com.fiap.challange.model;

public class StatusCombustivelModel {

	private Long statusCombustivelId;
	private Long tipoCombustivelId;
	private String combustivelAdulterado;

	public Long getStatusCombustivelId() {
		return statusCombustivelId;
	}

	public void setStatusCombustivelId(Long statusCombustivelId) {
		this.statusCombustivelId = statusCombustivelId;
	}

	public Long getTipoCombustivelId() {
		return tipoCombustivelId;
	}

	public void setTipoCombustivelId(Long tipoCombustivelId) {
		this.tipoCombustivelId = tipoCombustivelId;
	}

	public String getCombustivelAdulterado() {
		return combustivelAdulterado;
	}

	public void setCombustivelAdulterado(String combustivelAdulterado) {
		this.combustivelAdulterado = combustivelAdulterado;
	}

}
