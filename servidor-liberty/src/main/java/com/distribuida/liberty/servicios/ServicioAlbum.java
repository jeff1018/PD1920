package com.distribuida.liberty.servicios;

import java.util.List;

import com.distribuida.liberty.dto.Album;

public interface ServicioAlbum {	
	void crear(Album album);
	void editar(Album album, int id) ;
	void eliminar(Integer id);
	List<Album> listar() ;
	Album buscarPorId(Integer id);
}
