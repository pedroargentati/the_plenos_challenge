package br.com.fiap.challange.entity;

import br.com.fiap.challange.model.VeiculoModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "Veiculo")
@Table(name = "Veiculo")
public class VeiculoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer veiculoId;
	private String veiculoChassi;
	private String veiculoPlaca;
	private Integer veiculoMetragem;
	private Integer clienteId;
	
	public VeiculoEntity() {}
	
	public VeiculoEntity(VeiculoModel model) {
		this(model.getVeiculoId(), model.getVeiculoChassi(), model.getVeiculoPlaca(), model.getVeiculoMetragem(), model.getClienteId());
	}
	
	public VeiculoEntity(Integer veiculoId, String veiculoChassi, String veiculoPlaca, Integer veiculoMetragem,
			Integer clienteId) {
		super();
		this.veiculoId = veiculoId;
		this.veiculoChassi = veiculoChassi;
		this.veiculoPlaca = veiculoPlaca;
		this.veiculoMetragem = veiculoMetragem;
		this.clienteId = clienteId;
	}

	public Integer getVeiculoId() {
		return veiculoId;
	}

	public void setVeiculoId(Integer veiculoId) {
		this.veiculoId = veiculoId;
	}

	public String getVeiculoChassi() {
		return veiculoChassi;
	}

	public void setVeiculoChassi(String veiculoChassi) {
		this.veiculoChassi = veiculoChassi;
	}

	public String getVeiculoPlaca() {
		return veiculoPlaca;
	}

	public void setVeiculoPlaca(String veiculoPlaca) {
		this.veiculoPlaca = veiculoPlaca;
	}

	public Integer getVeiculoMetragem() {
		return veiculoMetragem;
	}

	public void setVeiculoMetragem(Integer veiculoMetragem) {
		this.veiculoMetragem = veiculoMetragem;
	}

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}
	
}
