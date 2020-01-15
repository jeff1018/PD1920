package com.distribuida.liberty.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.distribuida.liberty.dto.Singer;
import com.distribuida.liberty.servicios.ServicioSinger;

import javax.enterprise.context.ApplicationScoped;

@Path("/singer")
@ApplicationScoped
public class SingerRest {
	
	@Inject private ServicioSinger singerService;
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Singer listarId(@PathParam(value = "id") Integer id) {
		Singer singer = singerService.buscarPorId(id);
		return singer;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Singer> listar() {
		return singerService.listar();	
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void crearSinger(Singer singer) {
		singerService.crear(singer);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public void editar(Singer singer,@PathParam("id") int id) {
		singerService.editar(singer,id);		
	}
	
	@DELETE
    @Path("/{id}")
	public Response borrarSinger(@PathParam("id") Integer id) {
		Singer singer = singerService.buscarPorId(id);
		if (singer != null) {
			singerService.eliminar(id);
		} else {
			System.out.print("No se pudo eliminar");
		}
		return Response.ok("Eliminado").build();
	}
}
