package com.samuelpace.todo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samuelpace.todo.domain.Todo;
import com.samuelpace.todo.repositorys.TodoRepo;
import com.samuelpace.todo.services.exception.ObjectNotFoundException;

@Service
public class TodoService {

	@Autowired
	private TodoRepo repo;

	public Todo findById(Integer id) {
		Optional<Todo> obj = repo.findById(id);
		return obj.orElseThrow(
				() -> new ObjectNotFoundException("Objeto não encontrado " + id + ", Tipo: " + Todo.class.getName()));
	}

	public List<Todo> findAllOpen() {
		List<Todo> list = repo.findAllOpen();
		{
			return list;
		}
	}

	public List<Todo> findAllClose() {
		List<Todo> list = repo.findAllClose();
		{
			return list;
		}
	}

	public List<Todo> findAll() {
		List<Todo> list = repo.findAll();
		return list;

	}

	public Todo create(Todo obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public void delete(Integer id) {
		repo.deleteById(id);

	}

	public Todo update(Integer id, Todo obj) {
		Todo newObj = findById(id);
		newObj.setTitulo(obj.getTitulo());
		newObj.setDataParaFinalizar(obj.getDataParaFinalizar());
		newObj.setDescricao(obj.getDescricao());
		newObj.setFinalizado(obj.getFinalizado());
		return repo.save(newObj);
	}
}
