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
import com.idat.pe.modelo.Bus;
import com.idat.pe.repositorio.BusRepositorio;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class BusControlador {
	@Autowired
	private BusRepositorio repositorio;

	//este metodo sirve para listar todos los empleados
	@GetMapping("/bus")
	public List<Bus> listarTodosLosBuses() {
		return repositorio.findAll();
	}
	

	//este metodo sirve para guardar el empleado
	@PostMapping("/bus")
	public Bus guardarBus(@RequestBody Bus bus) {
		return repositorio.save(bus);
	}
    
	//este metodo sirve para buscar un empleado
	@GetMapping("/bus/{id}")
	public ResponseEntity<Bus> obtenerBusPorId(@PathVariable Long id) {
		Bus bus = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("El bus con el ID : " + id + " no existe"));
		return ResponseEntity.ok(bus);
	}

	// este metodo sirve para actualizar empleado
	@PutMapping("/bus/{id}")
	public ResponseEntity<Bus> actualizarBus(@PathVariable Long id, @RequestBody Bus detallesBuses) {
		Bus bus = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("El bus con el ID : " + id + " no existe"));

		bus.setPlaca(detallesBuses.getPlaca());
		bus.setCapacidad(detallesBuses.getCapacidad());
		bus.setPisos(detallesBuses.getPisos());
		

		Bus busActualizado = repositorio.save(bus);
		return ResponseEntity.ok(busActualizado);
	}

	// este metodo sirve para eliminar un empleado
	@DeleteMapping("/bus/{id}")
	public ResponseEntity<Map<String, Boolean>> eliminarUsuarios(@PathVariable Long id) {
		Bus bus = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("El bus con el ID : " + id + " no existe"));

		repositorio.delete(bus);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar", Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
	}
}
