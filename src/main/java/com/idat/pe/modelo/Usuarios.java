package com.idat.pe.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuarios {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usuarios;
	
	@Column(name = "tipo_doc", length = 60, nullable = false)
	private String tipo_doc;

	@Column(name = "nro_documento", length = 60, nullable = false)
	private String nro_documento;
	
	@Column(name = "nombres", length = 60, nullable = false)
	private String nombres;
	
	@Column(name = "apellidos", length = 60, nullable = false)
	private String apellidos;
	
	@Column(name = "correo", length = 60, nullable = false)
	private String correo;
	
	@Column(name = "contrasena", length = 60, nullable = false)
	private String contrasena;
	
	@Column(name = "celular", length = 60, nullable = false)
	private String celular;





	public Usuarios() {

	}





	public Usuarios(Long id_usuarios, String tipo_doc, String nro_documento, String nombres, String apellidos,
			String correo, String contrasena, String celular) {
		super();
		this.id_usuarios = id_usuarios;
		this.tipo_doc = tipo_doc;
		this.nro_documento = nro_documento;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
		this.contrasena = contrasena;
		this.celular = celular;
	}





	public Long getId_usuarios() {
		return id_usuarios;
	}





	public void setId_usuarios(Long id_usuarios) {
		this.id_usuarios = id_usuarios;
	}





	public String getTipo_doc() {
		return tipo_doc;
	}





	public void setTipo_doc(String tipo_doc) {
		this.tipo_doc = tipo_doc;
	}





	public String getNro_documento() {
		return nro_documento;
	}





	public void setNro_documento(String nro_documento) {
		this.nro_documento = nro_documento;
	}





	public String getNombres() {
		return nombres;
	}





	public void setNombres(String nombres) {
		this.nombres = nombres;
	}





	public String getApellidos() {
		return apellidos;
	}





	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}





	public String getCorreo() {
		return correo;
	}





	public void setCorreo(String correo) {
		this.correo = correo;
	}





	public String getContrasena() {
		return contrasena;
	}





	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}





	public String getCelular() {
		return celular;
	}





	public void setCelular(String celular) {
		this.celular = celular;
	}

	
	}