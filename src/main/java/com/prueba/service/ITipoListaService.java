package com.prueba.service;

import java.util.List;

import com.prueba.model.TipoLista;

public interface ITipoListaService extends ICrudService<TipoLista> {

	List<TipoLista> traerTipoListasEstado(int activo);

}
