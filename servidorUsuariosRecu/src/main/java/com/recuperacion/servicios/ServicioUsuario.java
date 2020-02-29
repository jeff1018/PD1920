package com.recuperacion.servicios;

import java.util.List;

import com.recuperacion.dto.Usuario;

public interface ServicioUsuario {

	public List<Usuario> listar();
	public Usuario buscarPorId(Integer id);	
}
