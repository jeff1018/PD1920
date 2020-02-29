package com.recuperacion.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.recuperacion.dto.Todo;
import com.recuperacion.rest.JaxTodo;

@Named(value = "beanTodo")
@ApplicationScoped
public class BeanTodo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Todo todo;
	private List<Todo> lista;
	
	private JaxTodo servicio = new JaxTodo();
	
	@PostConstruct
	public void iniciar() {
		todo = new Todo();
		lista = servicio.buscarTodos();
	}

	public Todo getTodo() {
		return todo;
	}

	public void setTodo(Todo todo) {
		this.todo = todo;
	}

	public List<Todo> getLista() {
		return lista;
	}

	public void setLista(List<Todo> lista) {
		this.lista = lista;
	}

}
