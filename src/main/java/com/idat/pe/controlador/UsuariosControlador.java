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
import com.idat.pe.modelo.Usuarios;
import com.idat.pe.repositorio.UsuariosRepositorio;


@RestController
@RequestMapping("/api/v3/")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuariosControlador {

	@Autowired
	private UsuariosRepositorio repositorio;

	// este metodo sirve para listar todos los empleados
	@GetMapping("/usuarios")
	public List<Usuarios> listarTodosLosUsuarios() {
		return repositorio.findAll();
	}

	// este metodo sirve para guardar el empleado
	@PostMapping("/usuarios")
	public Usuarios guardarUsuarios(@RequestBody Usuarios usuarios) {
		return repositorio.save(usuarios);
	}

	// este metodo sirve para buscar un empleado
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Usuarios> obtenerUsuariosPorId(@PathVariable Long id) {
		Usuarios usuarios = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("El usuario con el ID : " + id + " no existe"));
		return ResponseEntity.ok(usuarios);
	}

	// este metodo sirve para actualizar empleado
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<Usuarios> actualizarUsuarios(@PathVariable Long id, @RequestBody Usuarios detallesUsuarios) {
		Usuarios usuarios = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("El usuario con el ID : " + id + " no existe"));

		usuarios.setTipo_doc(detallesUsuarios.getTipo_doc());
		usuarios.setNro_documento(detallesUsuarios.getTipo_doc());
		usuarios.setNombres(detallesUsuarios.getNombres());
		usuarios.setApellidos(detallesUsuarios.getApellidos());
		usuarios.setCorreo(detallesUsuarios.getCorreo());
		usuarios.setContrasena(detallesUsuarios.getContrasena());
		usuarios.setCelular(detallesUsuarios.getCelular());
		

		Usuarios usuariosActualizado = repositorio.save(usuarios);
		return ResponseEntity.ok(usuariosActualizado);
	}

	// este metodo sirve para eliminar un empleado
	@DeleteMapping("/usuarios/{id}")
	public ResponseEntity<Map<String, Boolean>> eliminarUsuarios(@PathVariable Long id) {
		Usuarios usuarios = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("El usuario con el ID : " + id + " no existe"));

		repositorio.delete(usuarios);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar", Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
	}
}