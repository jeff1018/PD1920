package com.recuperacion.rest;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.recuperacion.dto.Todo;
import com.recuperacion.servicios.ServicioTodo;

@Path("/todo")
@ApplicationScoped
public class TodoRest {

	@Inject
	ServicioTodo servicioTodo;
	

	@GET
	@Path(value = "/ping")
	@Produces(MediaType.APPLICATION_JSON)
	public String hola() {
		System.out.println("ping");
		return "ok";
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Todo listarId(@PathParam(value = "id") Integer id) {
		Todo t = servicioTodo.buscarPorId(id);
		return t;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Todo> listar() {
		List<Todo> lista = servicioTodo.listar();
		return lista;
	}
	
}
