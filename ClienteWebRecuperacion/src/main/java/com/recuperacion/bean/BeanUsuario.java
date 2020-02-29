package com.recuperacion.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.recuperacion.dto.Usuario;
import com.recuperacion.rest.JaxUsuario;

@Named(value = "beanUsuario")
@ApplicationScoped 
public class BeanUsuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	private List<Usuario> lista;
	
	private JaxUsuario servicio = new JaxUsuario();
	
	@PostConstruct
	public void iniciar() {
		usuario = new Usuario();
		lista = servicio.buscarTodos();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getLista() {
		return lista;
	}

	public void setLista(List<Usuario> lista) {
		this.lista = lista;
	}	
}
