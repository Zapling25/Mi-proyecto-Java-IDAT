package com.idat.pe.modelo;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_bus")
public class Bus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBus;
	@Column(name = "placa", length = 60, nullable = false)
	private String placa;
	@Column(name = "capacidad", length = 60, nullable = false)
	private int capacidad;
	@Column(name = "pisos", length = 60, nullable = false)
	private int pisos;
	
	public Bus() {
		
	}

	public Bus(Long idBus, String placa, int capacidad, int pisos) {
		super();
		this.idBus = idBus;
		this.placa = placa;
		this.capacidad = capacidad;
		this.pisos = pisos;
	}

	public Long getIdBus() {
		return idBus;
	}

	public void setIdBus(Long idBus) {
		this.idBus = idBus;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getPisos() {
		return pisos;
	}

	public void setPisos(int pisos) {
		this.pisos = pisos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(capacidad, idBus, pisos, placa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bus other = (Bus) obj;
		return capacidad == other.capacidad && Objects.equals(idBus, other.idBus) && pisos == other.pisos
				&& Objects.equals(placa, other.placa);
	}

	@Override
	public String toString() {
		return "Bus [idBus=" + idBus + ", placa=" + placa + ", capacidad=" + capacidad + ", pisos=" + pisos + "]";
	}
	
}
