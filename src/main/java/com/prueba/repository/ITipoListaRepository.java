package com.prueba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prueba.model.TipoLista;

@Repository
public interface ITipoListaRepository extends JpaRepository<TipoLista, Integer> {

	@Query("from TipoLista tl where tl.activo = :activo")
	List<TipoLista> traerTipoListasEstado(@Param("activo") int activo);

}