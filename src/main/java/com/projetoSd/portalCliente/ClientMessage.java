package com.projetoSd.portalCliente;

public class ClientMessage {

	private String cliente;
    private String text;

	//private Tarefa tarefa;

	public ClientMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClientMessage(String cliente, String text) {
		super();
		this.cliente = cliente;
		this.text = text;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	

}
