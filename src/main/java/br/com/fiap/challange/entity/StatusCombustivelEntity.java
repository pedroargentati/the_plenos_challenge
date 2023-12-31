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
	private Long statusCombustivelId;
	private Long tipoCombustivelId;
	private String qualidade;
	
	public StatusCombustivelEntity() {}

	public StatusCombustivelEntity(StatusCombustivelModel model) {
		this(model.getStatusCombustivelId(), model.getTipoCombustivelId(), model.getQualidade());
	}
	
	public StatusCombustivelEntity(Long statusCombustivelId, Long tipoCombustivelId, String qualidade) {
		super();
		this.statusCombustivelId = statusCombustivelId;
		this.tipoCombustivelId = tipoCombustivelId;
		this.qualidade = qualidade;
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

	public String getQualidade() {
		return qualidade;
	}

	public void setQualidade(String qualidade) {
		this.qualidade = qualidade;
	}
	
}
