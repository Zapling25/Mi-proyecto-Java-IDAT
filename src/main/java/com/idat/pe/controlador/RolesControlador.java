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
import com.idat.pe.modelo.Roles;
import com.idat.pe.repositorio.RolesRepositorio;


@RestController
@RequestMapping("/api/v2/")
@CrossOrigin(origins = "http://localhost:4200")
public class RolesControlador {

	@Autowired
	private RolesRepositorio repositorio;

	// este metodo sirve para listar todos los empleados
	@GetMapping("/roles")
	public List<Roles> listarTodosLosRoles() {
		return repositorio.findAll();
	}

	// este metodo sirve para guardar el empleado
	@PostMapping("/roles")
	public Roles guardarRoles(@RequestBody Roles roles) {
		return repositorio.save(roles);
	}

	// este metodo sirve para buscar un empleado
	@GetMapping("/roles/{id}")
	public ResponseEntity<Roles> obtenerRolesPorId(@PathVariable Long id) {
		Roles roles = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("El rol con el ID : " + id + " no existe"));
		return ResponseEntity.ok(roles);
	}

	// este metodo sirve para actualizar empleado
	@PutMapping("/roles/{id}")
	public ResponseEntity<Roles> actualizarRoles(@PathVariable Long id, @RequestBody Roles detallesRoles) {
		Roles roles = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("El rol con el ID : " + id + " no existe"));

		roles.setDescripcion(detallesRoles.getDescripcion());
		roles.setEstado(detallesRoles.getEstado());

		Roles rolesActualizado = repositorio.save(roles);
		return ResponseEntity.ok(rolesActualizado);
	}

	// este metodo sirve para eliminar un empleado
	@DeleteMapping("/roles/{id}")
	public ResponseEntity<Map<String, Boolean>> eliminarRoles(@PathVariable Long id) {
		Roles roles = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("El rol con el ID : " + id + " no existe"));

		repositorio.delete(roles);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar", Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
	}
}