package com.prueba.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tipos_listas")
public class TipoLista {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "tipo_lista_id", nullable = true)
	private TipoLista tipoListaId;

	@Column(name = "nombre", nullable = false, length = 255)
	private String nombreTipoLista;

	@Column(name = "descripcion", nullable = true, length = 500)
	private String descripcion;

	@Column(name = "activo", nullable = false, length = 1)
	private int activo;

}