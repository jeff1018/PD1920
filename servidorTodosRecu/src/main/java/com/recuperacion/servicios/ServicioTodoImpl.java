package com.recuperacion.servicios;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.recuperacion.dto.Todo;

@ApplicationScoped
@Transactional
public class ServicioTodoImpl implements ServicioTodo{

	@PersistenceContext(unitName = "todoPU")
	private EntityManager entityManager;
	
	@Override
	public List<Todo> listar() {
		List<Todo> lista = null;
		lista = entityManager.createNamedQuery("Todo.findAll", Todo.class).getResultList();
		return lista;
	}

	@Override
	public Todo buscarPorId(Integer id) {
		Todo t = null;
		t = entityManager.find(Todo.class, id);
		return t;
	}

}
