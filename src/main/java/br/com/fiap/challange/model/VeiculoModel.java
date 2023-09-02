package br.com.fiap.challange.model;

public class VeiculoModel {

	private Integer veiculoId;
	private String veiculoChassi;
	private String veiculoPlaca;
	private Integer veiculoMetragem;
	private Integer clienteId;

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
