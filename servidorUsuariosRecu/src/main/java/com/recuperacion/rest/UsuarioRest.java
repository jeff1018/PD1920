package com.recuperacion.rest;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.recuperacion.dto.Usuario;
import com.recuperacion.servicios.ServicioUsuario;

@Path("/usuario")
@ApplicationScoped
public class UsuarioRest {

	@Inject
	ServicioUsuario servicioUsuario;
	
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
	public Usuario listarId(@PathParam(value = "id") Integer id) {
		Usuario usuario = servicioUsuario.buscarPorId(id);
		return usuario;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> listar() {
		List<Usuario> lista = servicioUsuario.listar();
		return lista;
	}
}
