package com.projetoSd.portalCliente;

import java.util.HashMap;
import java.util.Map;

//domino para salvar os clientes cadastrados no portal administrador

public class BaseClientes {

	Map<String, String> clientes = new HashMap<String, String>();

	public BaseClientes() {
		super();
		this.clientes.put("paulo", "paulo junior");
	}

	public BaseClientes(Map<String, String> clientes) {
		super();
		this.clientes = clientes;
		this.clientes.put("paulo", "paulo junior");
	}

	public Map<String, String> getClientes() {
		return clientes;
	}

	public void setClientes(Map<String, String> clientes) {
		this.clientes = clientes;
	}

}
