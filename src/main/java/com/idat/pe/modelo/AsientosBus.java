package com.idat.pe.modelo;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_asientos_bus")
public class AsientosBus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idasiento;
	@JoinColumn(name = "tb_bus", referencedColumnName = "id_rol")
    @ManyToOne(optional = false)
    private Bus bus;
	@Column(name = "cod_asiento", length = 60, nullable = false)
	private int codAsiento;
	@Column(name = "inclinacion", length = 60, nullable = false)
	private String inclinacion;
	@Column(name = "precio", length = 60, nullable = false)
	private Double precio;
	@Column(name = "piso_bus", length = 60, nullable = false)
	private int pisoBus;
	@Column(name = "estado", length = 60, nullable = false)
	private Boolean estado;
	
	public AsientosBus() {
		
	}

	public AsientosBus(Long idasiento, Bus bus, int codAsiento, String inclinacion, Double precio, int pisoBus,
			Boolean estado) {
		super();
		this.idasiento = idasiento;
		this.bus = bus;
		this.codAsiento = codAsiento;
		this.inclinacion = inclinacion;
		this.precio = precio;
		this.pisoBus = pisoBus;
		this.estado = estado;
	}

	public Long getIdasiento() {
		return idasiento;
	}

	public void setIdasiento(Long idasiento) {
		this.idasiento = idasiento;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public int getCodAsiento() {
		return codAsiento;
	}

	public void setCodAsiento(int codAsiento) {
		this.codAsiento = codAsiento;
	}

	public String getInclinacion() {
		return inclinacion;
	}

	public void setInclinacion(String inclinacion) {
		this.inclinacion = inclinacion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public int getPisoBus() {
		return pisoBus;
	}

	public void setPisoBus(int pisoBus) {
		this.pisoBus = pisoBus;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bus, codAsiento, estado, idasiento, inclinacion, pisoBus, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AsientosBus other = (AsientosBus) obj;
		return Objects.equals(bus, other.bus) && codAsiento == other.codAsiento && Objects.equals(estado, other.estado)
				&& Objects.equals(idasiento, other.idasiento) && Objects.equals(inclinacion, other.inclinacion)
				&& pisoBus == other.pisoBus && Objects.equals(precio, other.precio);
	}

	@Override
	public String toString() {
		return "AsientosBus [idasiento=" + idasiento + ", bus=" + bus + ", codAsiento=" + codAsiento + ", inclinacion="
				+ inclinacion + ", precio=" + precio + ", pisoBus=" + pisoBus + ", estado=" + estado + "]";
	}

	

	
	
}
