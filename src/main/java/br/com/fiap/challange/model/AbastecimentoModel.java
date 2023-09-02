package br.com.fiap.challange.model;

import java.util.Date;

public class AbastecimentoModel {

	private Integer abastecimentoId;
	private Date    abastecimentoDate;
	private String  abastecimentoCoordenada;
	private Integer statusCombustivelid;
	private Integer tipoCombustivelId;
	private Integer veiculoId;
	private Integer enderecoId;

	public Integer getAbastecimentoId() {
		return abastecimentoId;
	}

	public void setAbastecimentoId(Integer abastecimentoId) {
		this.abastecimentoId = abastecimentoId;
	}

	public Date getAbastecimentoDate() {
		return abastecimentoDate;
	}

	public void setAbastecimentoDate(Date abastecimentoDate) {
		this.abastecimentoDate = abastecimentoDate;
	}

	public String getAbastecimentoCoordenada() {
		return abastecimentoCoordenada;
	}

	public void setAbastecimentoCoordenada(String abastecimentoCoordenada) {
		this.abastecimentoCoordenada = abastecimentoCoordenada;
	}

	public Integer getStatusCombustivelid() {
		return statusCombustivelid;
	}

	public void setStatusCombustivelid(Integer statusCombustivelid) {
		this.statusCombustivelid = statusCombustivelid;
	}

	public Integer getTipoCombustivelId() {
		return tipoCombustivelId;
	}

	public void setTipoCombustivelId(Integer tipoCombustivelId) {
		this.tipoCombustivelId = tipoCombustivelId;
	}

	public Integer getVeiculoId() {
		return veiculoId;
	}

	public void setVeiculoId(Integer veiculoId) {
		this.veiculoId = veiculoId;
	}

	public Integer getEnderecoId() {
		return enderecoId;
	}

	public void setEnderecoId(Integer enderecoId) {
		this.enderecoId = enderecoId;
	}

}
