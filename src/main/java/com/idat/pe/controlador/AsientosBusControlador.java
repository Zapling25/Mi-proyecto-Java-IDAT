package com.idat.pe.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.pe.excepciones.ResourceNotFoundException;
import com.idat.pe.modelo.AsientosBus;
import com.idat.pe.repositorio.AsientosBusRepositorio;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class AsientosBusControlador {

	@Autowired
	private AsientosBusRepositorio repositorio;

	//este metodo sirve para listar todos los empleados
	@GetMapping("/asientos")
	public List<AsientosBus> listarTodosLosEmpleados() {
		return repositorio.findAll();
	}
	

	//este metodo sirve para guardar el empleado
	@PostMapping("/asientos")
	public AsientosBus guardarAsiento(@RequestBody AsientosBus asientos) {
		return repositorio.save(asientos);
	}
    
	//este metodo sirve para buscar un empleado
	@GetMapping("/asientos/{id}")
	public ResponseEntity<AsientosBus> obtenerAsientoPorId(@PathVariable Long id) {
		AsientosBus asientos = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("El asiento con el ID : " + id + " no existe"));
		return ResponseEntity.ok(asientos);
	}

	// este metodo sirve para actualizar empleado
	@PutMapping("/asientos/{id}")
	public ResponseEntity<AsientosBus> actualizarAsiento(@PathVariable Long id, @RequestBody AsientosBus detallesBuses) {
		AsientosBus asientos = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("El asiento con el ID : " + id + " no existe"));

		asientos.setCodAsiento(detallesBuses.getCodAsiento());
		asientos.setBus(detallesBuses.getBus());
		asientos.setInclinacion(detallesBuses.getInclinacion());
		asientos.setPrecio(detallesBuses.getPrecio());
		asientos.setPisoBus(detallesBuses.getPisoBus());
		asientos.setEstado(detallesBuses.getEstado());
		

		AsientosBus asientosActualizado = repositorio.save(asientos);
		return ResponseEntity.ok(asientosActualizado);
	}

	// este metodo sirve para eliminar un empleado
	@DeleteMapping("/asientos/{id}")
	public ResponseEntity<Map<String, Boolean>> eliminarUsuarios(@PathVariable Long id) {
		AsientosBus asientos = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("El asiento con el ID : " + id + " no existe"));

		repositorio.delete(asientos);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar", Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
	}
}
