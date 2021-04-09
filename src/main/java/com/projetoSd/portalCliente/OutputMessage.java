package com.projetoSd.portalCliente;


//entidade que emite a resposta do servidor
public class OutputMessage {

	private String sender;
	private String message;
	private String time;

	public OutputMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OutputMessage(String sender, String message, String time) {
		super();
		this.sender = sender;
		this.message = message;
		this.time = time;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
