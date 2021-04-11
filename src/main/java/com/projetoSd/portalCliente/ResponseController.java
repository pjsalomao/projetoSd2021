package com.projetoSd.portalCliente;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ResponseController {

	// controla os eventos do app

	private BaseClientes baseClientes = new BaseClientes();

	// instancia a tabela hash para salvar os dados inseridos pelo cliente
	Map<String, Tarefa> tarefas = new HashMap<String, Tarefa>();

	@MessageMapping("/chat")
	@SendTo("/topic/messages")
	public OutputMessage send(Message message) throws Exception {
		String time = new SimpleDateFormat("HH:mm").format(new Date());
		return new OutputMessage(message.getFrom(), message.getText(), time);
	}

	// verifica se o usario fornecido pelo cliente esta cadastrado na base de dados
	@MessageMapping("/login")
	@SendTo("/topic/messages")
	public OutputMessage login(ClientMessage message) throws Exception {

		String time = new SimpleDateFormat("HH:mm").format(new Date());

		ClientMessage logado = baseClientes.getClientes().containsKey(message.getCliente()) ? message : null;

		if (logado == null) {
			return new OutputMessage("unauthorized", "Cliente não encontrado", time);
		}

		return new OutputMessage(logado.getCliente(), "", time);
	}

	@MessageMapping("/insere")
	@SendTo("/topic/messages")
	public OutputMessage insereTarefa(Tarefa tarefa) throws Exception {

		String time = new SimpleDateFormat("HH:mm").format(new Date());

		tarefas.put(tarefa.getClienteId() + tarefa.getTitulo(), tarefa);

		return new OutputMessage(tarefa.getClienteId(), "Inserido " + tarefa.getTitulo() + "-" + tarefa.getDescricao(),
				time);
	}

	@MessageMapping("/modifica")
	@SendTo("/topic/messages")
	public OutputMessage modificaTarefa(Tarefa tarefa) throws Exception {

		String time = new SimpleDateFormat("HH:mm").format(new Date());

		tarefas.replace(tarefa.getClienteId() + tarefa.getTitulo(), tarefa);

		return new OutputMessage(tarefa.getClienteId(),
				"Modificado " + tarefa.getTitulo() + "-" + tarefa.getDescricao(), time);
	}

	@MessageMapping("/lista")
	@SendTo("/topic/messages")
	public OutputMessage listaTarefa(Tarefa tarefa) throws Exception {

		String time = new SimpleDateFormat("HH:mm").format(new Date());

		String lista = "";

		for (Map.Entry<String, Tarefa> entrada : tarefas.entrySet()) {
			if (entrada.getValue().getClienteId().equals(tarefa.getClienteId())) {
				lista += " Codigo: " + entrada.getKey() + "; Titulo: " + entrada.getValue().getTitulo() + " Descrição: "
						+ entrada.getValue().getDescricao() + " ### ";
			}

		}

		return new OutputMessage(tarefa.getClienteId(), lista,
				time);
	}

	@MessageMapping("/apaga")
	@SendTo("/topic/messages")
	public OutputMessage apagarTarefa(Tarefa tarefa) throws Exception {

		String time = new SimpleDateFormat("HH:mm").format(new Date());

		tarefas.remove(tarefa.getClienteId() + tarefa.getTitulo());

		return new OutputMessage(tarefa.getClienteId(), "Excluido " + tarefa.getTitulo() + "-" + tarefa.getDescricao(),
				time);
	}

}
