package com.prueba.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.model.TipoLista;
import com.prueba.service.ITipoListaService;

@RestController
@RequestMapping("/api/tipo-lista")
public class ControladorTipoListaRest {

	@Autowired
	private ITipoListaService servicio;

	@GetMapping("/listarTodos")
	public List<TipoLista> listarTodos() {
		return servicio.listarTodos();
	}

	@GetMapping("/listar/{id}")
	public TipoLista listarPorId(@PathVariable int id) {
		return servicio.listarPorId(id);
	}

	@PostMapping("/registrar")
	public void registrar(@RequestBody TipoLista objeto) {
		servicio.registrar(objeto);
	}

	@PutMapping("/actualizar")
	public void actualizar(@RequestBody TipoLista objeto) {
		servicio.actualizar(objeto);
	}

	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable int id) {
		servicio.eliminar(id);
	}

	@GetMapping("/traerInactivos/{activo}")
	public List<TipoLista> traerInactivos(@PathVariable int activo) {
		return servicio.traerTipoListasEstado(activo);
	}

}
