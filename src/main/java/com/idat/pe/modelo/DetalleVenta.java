package com.idat.pe.modelo;

import java.sql.Date;
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
@Table(name = "tb_detalle_venta")
public class DetalleVenta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVenta;
	@JoinColumn(name = "tb_pasajero", referencedColumnName = "iduser")
    @ManyToOne(optional = false)
	private Pasajero pasajero;
	@JoinColumn(name = "tb_asientos_bus", referencedColumnName = "idasiento")
    @ManyToOne(optional = false)
	private AsientosBus asientoBus;
	@Column(name = "fecha_venta", length = 60, nullable = false)
	private Date fechaVenta;
	@Column(name = "sub_total", length = 60, nullable = false)
	private Double subTotal;
	@Column(name = "metodo_pago", length = 60, nullable = false)
	private String metodoPago;
	@Column(name = "igv", length = 60, nullable = false)
	private Double igv;
	@Column(name = "descuento", length = 60, nullable = false)
	private Double descuento;
	@Column(name = "total", length = 60, nullable = false)
	private Double total;
	
	public DetalleVenta() {
		
	}

	public DetalleVenta(Long idVenta, Pasajero pasajero, AsientosBus asientoBus, Date fechaVenta, Double subTotal,
			String metodoPago, Double igv, Double descuento, Double total) {
		super();
		this.idVenta = idVenta;
		this.pasajero = pasajero;
		this.asientoBus = asientoBus;
		this.fechaVenta = fechaVenta;
		this.subTotal = subTotal;
		this.metodoPago = metodoPago;
		this.igv = igv;
		this.descuento = descuento;
		this.total = total;
	}

	public Long getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Long idVenta) {
		this.idVenta = idVenta;
	}

	public Pasajero getPasajero() {
		return pasajero;
	}

	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}

	public AsientosBus getAsientoBus() {
		return asientoBus;
	}

	public void setAsientoBus(AsientosBus asientoBus) {
		this.asientoBus = asientoBus;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public String getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}

	public Double getIgv() {
		return igv;
	}

	public void setIgv(Double igv) {
		this.igv = igv;
	}

	public Double getDescuento() {
		return descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public int hashCode() {
		return Objects.hash(asientoBus, descuento, fechaVenta, idVenta, igv, metodoPago, pasajero, subTotal, total);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetalleVenta other = (DetalleVenta) obj;
		return Objects.equals(asientoBus, other.asientoBus) && Objects.equals(descuento, other.descuento)
				&& Objects.equals(fechaVenta, other.fechaVenta) && Objects.equals(idVenta, other.idVenta)
				&& Objects.equals(igv, other.igv) && Objects.equals(metodoPago, other.metodoPago)
				&& Objects.equals(pasajero, other.pasajero) && Objects.equals(subTotal, other.subTotal)
				&& Objects.equals(total, other.total);
	}

	@Override
	public String toString() {
		return "DetalleVenta [idVenta=" + idVenta + ", pasajero=" + pasajero + ", asientoBus=" + asientoBus
				+ ", fechaVenta=" + fechaVenta + ", subTotal=" + subTotal + ", metodoPago=" + metodoPago + ", igv="
				+ igv + ", descuento=" + descuento + ", total=" + total + "]";
	}
	
	
}
