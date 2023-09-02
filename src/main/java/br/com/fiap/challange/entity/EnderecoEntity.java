package br.com.fiap.challange.entity;

import br.com.fiap.challange.model.EnderecoModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "Endereco")
@Table(name = "Endereco")
public class EnderecoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer enderecoId;
	private String rua;
	private String bairro;
	private String cidade;
	private String pais;
	private String continente;
	private String tipoLugar;
	
	public EnderecoEntity() {}
	
	public EnderecoEntity(EnderecoModel model) {
		this(model.getEnderecoId(), model.getRua(), model.getBairro(), model.getCidade(), model.getPais(), model.getContinente(), model.getTipoLugar());
	}
	
	public EnderecoEntity(Integer enderecoId, String rua, String bairro, String cidade, String pais, String continente,
			String tipoLugar) {
		super();
		this.enderecoId = enderecoId;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.pais = pais;
		this.continente = continente;
		this.tipoLugar = tipoLugar;
	}

	public Integer getEnderecoId() {
		return enderecoId;
	}

	public void setEnderecoId(Integer enderecoId) {
		this.enderecoId = enderecoId;
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
