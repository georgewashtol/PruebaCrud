package com.prueba.service;

import java.util.List;

public interface ICrudService<T> {

	List<T> listarTodos();

	T listarPorId(int id);

	void registrar(T objeto);

	void actualizar(T objeto);

	void eliminar(int id);
}
