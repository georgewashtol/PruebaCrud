package com.prueba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.model.TipoLista;
import com.prueba.repository.ITipoListaRepository;
import com.prueba.service.ITipoListaService;

@Service
public class TipoListaServiceImpl implements ITipoListaService {

	@Autowired
	private ITipoListaRepository repositorio;

	@Override
	public List<TipoLista> listarTodos() {
		return repositorio.findAll();
	}

	@Override
	public TipoLista listarPorId(int id) {
		return repositorio.findById(id).orElse(null);
	}

	@Override
	public void registrar(TipoLista objeto) {
		repositorio.save(objeto);
	}

	@Override
	public void actualizar(TipoLista objeto) {
		repositorio.save(objeto);
	}

	@Override
	public void eliminar(int id) {
		repositorio.deleteById(id);
	}

	@Override
	public List<TipoLista> traerTipoListasEstado(int activo) {
		return repositorio.traerTipoListasEstado(activo);
	}

}
