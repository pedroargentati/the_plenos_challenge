package br.com.fiap.challange.model;

import java.util.Date;

public class CombustivelModel {

	private Long id;
	private String nomePosto;
	private String endereco;
	private Date data;
	private String tipo;
	private String qualidade;

	public CombustivelModel() {
		super();
	}

	public CombustivelModel(Long id, String nomePosto, String endereco, Date data, String tipo, String qualidade) {
		super();
		this.id = id;
		this.nomePosto = nomePosto;
		this.endereco = endereco;
		this.data = data;
		this.tipo = tipo;
		this.qualidade = qualidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomePosto() {
		return nomePosto;
	}

	public void setNomePosto(String nomePosto) {
		this.nomePosto = nomePosto;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getQualidade() {
		return qualidade;
	}

	public void setQualidade(String qualidade) {
		this.qualidade = qualidade;
	}

	@Override
	public String toString() {
		return "CombustivelModel [id=" + id + ", nomePosto=" + nomePosto + ", endereco=" + endereco + ", data=" + data
				+ ", tipo=" + tipo + ", qualidade=" + qualidade + "]";
	}

}
