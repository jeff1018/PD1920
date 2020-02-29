package com.recuperacion.servicios;

import java.util.List;

import com.recuperacion.dto.Todo;

public interface ServicioTodo {

	public List<Todo> listar();
	public Todo buscarPorId(Integer id);	
}
