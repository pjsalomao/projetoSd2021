package com.projetoSd.portalCliente;

public class Tarefa {

	private String clienteId;
	private String titulo;
	private String descricao;

	public Tarefa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tarefa(String clienteId, String titulo, String descricao) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.clienteId = clienteId;
	}

	public String getClienteId() {
		return clienteId;
	}

	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
