package br.com.fiap.challange.entity;

import br.com.fiap.challange.model.StatusCombustivelModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "StatusCombustivel")
@Table(name = "StatusCombustivel")
public class StatusCombustivelEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer statusCombustivelId;
	private Integer tipoCombustivelId;
	private String combustivelAdulterado;
	
	public StatusCombustivelEntity() {}

	public StatusCombustivelEntity(StatusCombustivelModel model) {
		this(model.getStatusCombustivelId(), model.getTipoCombustivelId(), model.getCombustivelAdulterado());
	}
	
	public StatusCombustivelEntity(Integer statusCombustivelId, Integer tipoCombustivelId, String combustivelAdulterado) {
		super();
		this.statusCombustivelId = statusCombustivelId;
		this.tipoCombustivelId = tipoCombustivelId;
		this.combustivelAdulterado = combustivelAdulterado;
	}

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
