package com.distribuida.liberty.rest;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
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

import com.distribuida.liberty.dto.Album;
import com.distribuida.liberty.servicios.ServicioAlbum;

@Path("/album")
@ApplicationScoped
public class AlbumRest {
	
	@Inject private ServicioAlbum albumService;

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Album listarId(@PathParam(value = "id") Integer id) {
		Album album = albumService.buscarPorId(id);
		return album;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Album> listar() {
		return albumService.listar();
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void crearAlbum(Album album) {
		albumService.crear(album);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void editar(Album album,@PathParam("id") int id) {
		albumService.editar(album,id);		
	}
	
	@DELETE
    @Path("/{id}")
	public Response borrarAlbum(@PathParam("id") Integer id) {

		Album album = albumService.buscarPorId(id);
		if (album != null) {
			albumService.eliminar(id);
		} else {
			System.out.print("No se pudo eliminar");
		}
		return Response.ok("Eliminado").build();
	}

}
