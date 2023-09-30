package br.com.fiap.challange.model;

public class StatusCombustivelModel {

	private Long statusCombustivelId;
	private Long tipoCombustivelId;
	private String qualidade;

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

	public String getQualidade() {
		return qualidade;
	}

	public void setQualidade(String qualidade) {
		this.qualidade = qualidade;
	}

}
