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
import com.idat.pe.modelo.DetalleViaje;
import com.idat.pe.repositorio.DetalleViajeRepositorio;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class DetalleViajeControllador {
	@Autowired
	private DetalleViajeRepositorio repositorio;

	//este metodo sirve para listar todos los empleados
	@GetMapping("/viaje")
	public List<DetalleViaje> listarTodosLosViajes() {
		return repositorio.findAll();
	}
	

	//este metodo sirve para guardar el empleado
	@PostMapping("/viaje")
	public DetalleViaje guardarViaje(@RequestBody DetalleViaje viaje) {
		return repositorio.save(viaje);
	}
    
	//este metodo sirve para buscar un empleado
	@GetMapping("/viaje/{id}")
	public ResponseEntity<DetalleViaje> obtenerViajePorId(@PathVariable Long id) {
		DetalleViaje viaje = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("El viaje con el ID : " + id + " no existe"));
		return ResponseEntity.ok(viaje);
	}

	// este metodo sirve para actualizar empleado
	@PutMapping("/viaje/{id}")
	public ResponseEntity<DetalleViaje> actualizarViaje(@PathVariable Long id, @RequestBody DetalleViaje detallesViaje) {
		DetalleViaje viaje = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("El viaje con el ID : " + id + " no existe"));

		viaje.setBus(detallesViaje.getBus());
		viaje.setFechaSalida(detallesViaje.getFechaSalida());
		viaje.setHoraSalida(detallesViaje.getHoraSalida());
		viaje.setHoraLlegada(detallesViaje.getHoraLlegada());
		viaje.setPuntoPartida(detallesViaje.getPuntoPartida());
		viaje.setPuntoLlegada(detallesViaje.getPuntoLlegada());
		viaje.setNroAsientos(detallesViaje.getNroAsientos());
		viaje.setDuracionViaje(detallesViaje.getNroAsientos());
		
		DetalleViaje viajeActualizado = repositorio.save(viaje);
		return ResponseEntity.ok(viajeActualizado);
	}

	// este metodo sirve para eliminar un empleado
	@DeleteMapping("/viaje/{id}")
	public ResponseEntity<Map<String, Boolean>> eliminarViajes(@PathVariable Long id) {
		DetalleViaje viaje = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("El viaje con el ID : " + id + " no existe"));

		repositorio.delete(viaje);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar", Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
	}
}
