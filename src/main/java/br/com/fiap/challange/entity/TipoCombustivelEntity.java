package br.com.fiap.challange.entity;

import br.com.fiap.challange.model.TipoCombustivelModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "TipoCombustivel")
@Table(name = "TipoCombustivel")
public class TipoCombustivelEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tipoCombustivelId;
	private String tipoCombustivelNome;

	public TipoCombustivelEntity() {}
	
	public TipoCombustivelEntity(TipoCombustivelModel model) {
		this(model.getTipoCombustivelId(), model.getTipoCombustivelNome());
	}
	
	public TipoCombustivelEntity(Integer tipoCombustivelId, String tipoCombustivelNome) {
		super();
		this.tipoCombustivelId = tipoCombustivelId;
		this.tipoCombustivelNome = tipoCombustivelNome;
	}

	public Integer getTipoCombustivelId() {
		return tipoCombustivelId;
	}

	public void setTipoCombustivelId(Integer tipoCombustivelId) {
		this.tipoCombustivelId = tipoCombustivelId;
	}

	public String getTipoCombustivelNome() {
		return tipoCombustivelNome;
	}

	public void setTipoCombustivelNome(String tipoCombustivelNome) {
		this.tipoCombustivelNome = tipoCombustivelNome;
	}
	
}
