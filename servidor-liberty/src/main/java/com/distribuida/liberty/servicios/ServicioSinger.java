package com.distribuida.liberty.servicios;

import java.util.List;

import com.distribuida.liberty.dto.Singer;

public interface ServicioSinger {
	void crear(Singer singer);
	void editar(Singer singer, int id);
	void eliminar(Integer id);
	List<Singer> listar();
	Singer buscarPorId(Integer id);	
}
