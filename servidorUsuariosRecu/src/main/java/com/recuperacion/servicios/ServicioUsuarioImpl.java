package com.recuperacion.servicios;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.recuperacion.dto.Usuario;

@ApplicationScoped
@Transactional
public class ServicioUsuarioImpl implements ServicioUsuario{

	@PersistenceContext(unitName = "usuarioPU")
	private EntityManager entityManager;
	
	@Override
	public List<Usuario> listar() {
		List<Usuario> lista = null;
		lista = entityManager.createNamedQuery("Usuario.findAll", Usuario.class).getResultList();
		return lista;
	}

	@Override
	public Usuario buscarPorId(Integer id) {
		Usuario usuario = null;
		usuario = entityManager.find(Usuario.class, id);
		return usuario;
	}
}
