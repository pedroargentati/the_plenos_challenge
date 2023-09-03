package br.com.fiap.challange.entity;

import java.util.Date;

import br.com.fiap.challange.model.AbastecimentoModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "Abastecimento")
@Table(name = "abastecimento")
public class AbastecimentoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer abastecimentoId;
	private Date abastecimentoDate;
	private String abastecimentoCoordenada;
	private Long statusCombustivelId;
	private Long tipoCombustivelId;
	private Integer veiculoId;
	private Integer enderecoId;
	
	public AbastecimentoEntity() {}
	
	public AbastecimentoEntity(AbastecimentoModel model) {
	    this(model.getAbastecimentoId(), model.getAbastecimentoDate(), model.getAbastecimentoCoordenada(),
	        model.getStatusCombustivelId(), model.getTipoCombustivelId(), model.getVeiculoId(), model.getEnderecoId());
	}

	public AbastecimentoEntity(Integer abastecimentoId, Date abastecimentoDate, String abastecimentoCoordenada,
			Long statusCombustivelId, Long tipoCombustivelId, Integer veiculoId, Integer enderecoId) {
	    super();
	    this.abastecimentoId = abastecimentoId;
	    this.abastecimentoDate = abastecimentoDate;
	    this.abastecimentoCoordenada = abastecimentoCoordenada;
	    this.statusCombustivelId = statusCombustivelId;
	    this.tipoCombustivelId = tipoCombustivelId;
	    this.veiculoId = veiculoId;
	    this.enderecoId = enderecoId;
	}

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

}
