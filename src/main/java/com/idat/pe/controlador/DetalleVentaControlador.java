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
import com.idat.pe.modelo.DetalleVenta;
import com.idat.pe.repositorio.DetalleVentaRepositorio;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class DetalleVentaControlador {
	@Autowired
	private DetalleVentaRepositorio repositorio;

	//este metodo sirve para listar todos los empleados
	@GetMapping("/venta")
	public List<DetalleVenta> listarTodosLasVentas() {
		return repositorio.findAll();
	}
	

	//este metodo sirve para guardar el empleado
	@PostMapping("/venta")
	public DetalleVenta guardarVenta(@RequestBody DetalleVenta venta) {
		return repositorio.save(venta);
	}
    
	//este metodo sirve para buscar un empleado
	@GetMapping("/venta/{id}")
	public ResponseEntity<DetalleVenta> obtenerVentaPorId(@PathVariable Long id) {
		DetalleVenta venta = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("La venta con el ID : " + id + " no existe"));
		return ResponseEntity.ok(venta);
	}

	// este metodo sirve para actualizar empleado
	@PutMapping("/venta/{id}")
	public ResponseEntity<DetalleVenta> actualizarVenta(@PathVariable Long id, @RequestBody DetalleVenta detallesVenta) {
		DetalleVenta venta = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("La venta con el ID : " + id + " no existe"));

		venta.setPasajero(detallesVenta.getPasajero());
		venta.setAsientoBus(detallesVenta.getAsientoBus());
		venta.setFechaVenta(detallesVenta.getFechaVenta());
		venta.setSubTotal(detallesVenta.getSubTotal());
		venta.setMetodoPago(detallesVenta.getMetodoPago());
		venta.setIgv(detallesVenta.getIgv());
		venta.setDescuento(detallesVenta.getDescuento());
		venta.setTotal(detallesVenta.getTotal());
		
		DetalleVenta ventaActualizado = repositorio.save(venta);
		return ResponseEntity.ok(ventaActualizado);
	}

	// este metodo sirve para eliminar un empleado
	@DeleteMapping("/venta/{id}")
	public ResponseEntity<Map<String, Boolean>> eliminarVentas(@PathVariable Long id) {
		DetalleVenta venta = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("La venta con el ID : " + id + " no existe"));

		repositorio.delete(venta);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar", Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
	}
}
