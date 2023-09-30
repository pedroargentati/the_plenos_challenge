package br.com.fiap.challange.model;

import java.util.Date;

public class OpencageDTOPOST extends EnderecoModel {
	
	private Integer abastecimentoId;
	private Date    abastecimentoDate;
	private String  abastecimentoCoordenada;
	private Long statusCombustivelId;
	private Long tipoCombustivelId;
	private Integer veiculoId;
	private Integer enderecoId;
	private String nomeTipoCombustivel;
	private String qualidade;
	private String enderecoFormatado;

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

	public String getNomeTipoCombustivel() {
		return nomeTipoCombustivel;
	}

	public void setNomeTipoCombustivel(String nomeTipoCombustivel) {
		this.nomeTipoCombustivel = nomeTipoCombustivel;
	}

	public String getQualidade() {
		return qualidade;
	}

	public void setQualidade(String qualidade) {
		this.qualidade = qualidade;
	}
	
	public String getEnderecoFormatado() {
		return enderecoFormatado;
	}

	public void setEnderecoFormatado(String enderecoFormatado) {
		this.enderecoFormatado = enderecoFormatado;
	}
}
