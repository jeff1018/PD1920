package com.recuperacion.rest;

import java.util.List;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.recuperacion.dto.Todo;
import com.recuperacion.dto.Usuario;

public class JaxTodo {

	//Puerto establecido para el gateway
		String enlace= "http://127.0.0.1:9999/todo/";
		
		ResteasyClient client = new ResteasyClientBuilder().build();
		Usuario usuario = new Usuario();
		
		ResteasyWebTarget getTotal = client.target(enlace);
		
		public List<Todo> buscarTodos() {
			Response getListadoTotal2 = getTotal.request().get();
			System.out.println(enlace);
			return getListadoTotal2.readEntity(new GenericType<List<Todo>>() {});
		}
		
		public Todo buscar(int id) {	
			ResteasyWebTarget getOpcion2 = client.target(enlace+id);
			Response getOp2 = getOpcion2.request().get();
			return getOp2.readEntity(Todo.class);     
		}
}
