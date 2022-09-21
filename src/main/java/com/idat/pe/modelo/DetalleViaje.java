package com.idat.pe.modelo;

import java.sql.Date;
import java.sql.Time;
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
@Table(name = "tb_detalle_viaje")
public class DetalleViaje {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idViaje;
	@JoinColumn(name = "tb_bus", referencedColumnName = "idbus")
    @ManyToOne(optional = false)
	private Bus bus;
	@Column(name = "fecha_salida", length = 60, nullable = false)
	private Date fechaSalida;
	@Column(name = "hora_salida", length = 60, nullable = false)
	private Time horaSalida;
	@Column(name = "hora_llegada", length = 60, nullable = false)
	private Time horaLlegada;
	@Column(name = "punto_partida", length = 60, nullable = false)
	private String puntoPartida;
	@Column(name = "punto_llegada", length = 60, nullable = false)
	private String puntoLlegada;
	@Column(name = "nro_asientos", length = 60, nullable = false)
	private int nroAsientos;
	@Column(name = "duracion_viaje", length = 60, nullable = false)
	private int duracionViaje;
	
	public DetalleViaje() {
		
	}

	public DetalleViaje(Long idViaje, Bus bus, Date fechaSalida, Time horaSalida, Time horaLlegada, String puntoPartida,
			String puntoLlegada, int nroAsientos, int duracionViaje) {
		super();
		this.idViaje = idViaje;
		this.bus = bus;
		this.fechaSalida = fechaSalida;
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
		this.puntoPartida = puntoPartida;
		this.puntoLlegada = puntoLlegada;
		this.nroAsientos = nroAsientos;
		this.duracionViaje = duracionViaje;
	}

	public Long getIdViaje() {
		return idViaje;
	}

	public void setIdViaje(Long idViaje) {
		this.idViaje = idViaje;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Time getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(Time horaSalida) {
		this.horaSalida = horaSalida;
	}

	public Time getHoraLlegada() {
		return horaLlegada;
	}

	public void setHoraLlegada(Time horaLlegada) {
		this.horaLlegada = horaLlegada;
	}

	public String getPuntoPartida() {
		return puntoPartida;
	}

	public void setPuntoPartida(String puntoPartida) {
		this.puntoPartida = puntoPartida;
	}

	public String getPuntoLlegada() {
		return puntoLlegada;
	}

	public void setPuntoLlegada(String puntoLlegada) {
		this.puntoLlegada = puntoLlegada;
	}

	public int getNroAsientos() {
		return nroAsientos;
	}

	public void setNroAsientos(int nroAsientos) {
		this.nroAsientos = nroAsientos;
	}

	public int getDuracionViaje() {
		return duracionViaje;
	}

	public void setDuracionViaje(int duracionViaje) {
		this.duracionViaje = duracionViaje;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bus, duracionViaje, fechaSalida, horaLlegada, horaSalida, idViaje, nroAsientos,
				puntoLlegada, puntoPartida);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetalleViaje other = (DetalleViaje) obj;
		return Objects.equals(bus, other.bus) && duracionViaje == other.duracionViaje
				&& Objects.equals(fechaSalida, other.fechaSalida) && Objects.equals(horaLlegada, other.horaLlegada)
				&& Objects.equals(horaSalida, other.horaSalida) && Objects.equals(idViaje, other.idViaje)
				&& nroAsientos == other.nroAsientos && Objects.equals(puntoLlegada, other.puntoLlegada)
				&& Objects.equals(puntoPartida, other.puntoPartida);
	}

	@Override
	public String toString() {
		return "DetalleViaje [idViaje=" + idViaje + ", bus=" + bus + ", fechaSalida=" + fechaSalida + ", horaSalida="
				+ horaSalida + ", horaLlegada=" + horaLlegada + ", puntoPartida=" + puntoPartida + ", puntoLlegada="
				+ puntoLlegada + ", nroAsientos=" + nroAsientos + ", duracionViaje=" + duracionViaje + "]";
	}
	
	
}
