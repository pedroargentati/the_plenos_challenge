package br.com.fiap.challange.entity;

import br.com.fiap.challange.model.ClienteModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "Cliente")
@Table(name = "Cliente")
public class ClienteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer clienteId;
	private String clienteNome;

	public ClienteEntity() {}
	
	public ClienteEntity(ClienteModel model) {
		this(model.getClienteId(), model.getClienteNome());
	}
	
	public ClienteEntity(Integer clienteId, String clienteNome) {
		super();
		this.clienteId = clienteId;
		this.clienteNome = clienteNome;
	}

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public String getClienteNome() {
		return clienteNome;
	}

	public void setClienteNome(String clienteNome) {
		this.clienteNome = clienteNome;
	}
	
}
