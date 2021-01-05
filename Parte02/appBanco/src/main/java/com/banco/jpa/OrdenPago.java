package com.banco.jpa;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "t_ordenpago")
@XmlRootElement(name = "OrdenPago")
public class OrdenPago implements Serializable {

	private static final long serialVersionUID = 7988023517320636435L;
	
	@Id 
	@Column(name = "idOrdenPago", insertable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOrdenPago;
	
	@Column(name= "monto")
	private BigDecimal monto;
	
	@Column(name= "moneda")
	private String moneda;
	
	@Column(name= "estado")
	private String estado;
	
	@Column(name= "fechaPago")
	private String fechaPago;
	
	@Column(name= "idSucursal")
	private int idSucursal;
	
	public OrdenPago() {
		// TODO Auto-generated constructor stub
	}

	public OrdenPago(int idOrdenPago, BigDecimal monto, String moneda, String estado, String fechaPago, int idSucursal) {
		super();
		this.idOrdenPago = idOrdenPago;
		this.monto = monto;
		this.moneda = moneda;
		this.estado = estado;
		this.fechaPago = fechaPago;
		this.idSucursal = idSucursal;
	}
	
	public OrdenPago(BigDecimal monto, String moneda, String estado, String fechaPago, int idSucursal) {
		super();
		this.monto = monto;
		this.moneda = moneda;
		this.estado = estado;
		this.fechaPago = fechaPago;
		this.idSucursal = idSucursal;
	}


	public BigDecimal getMonto() {
		return monto;
	}


	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}


	public String getMoneda() {
		return moneda;
	}


	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getFechaPago() {
		return fechaPago;
	}


	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}


	public int getIdOrdenPago() {
		return idOrdenPago;
	}


	public void setIdOrdenPago(int idOrdenPago) {
		this.idOrdenPago = idOrdenPago;
	}


	public int getIdSucursal() {
		return idSucursal;
	}


	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}


	@Override
	public String toString() {
		return "{idOrdenPago:\"" + idOrdenPago + "\", monto:\"" + monto + "\", moneda:\"" + moneda + "\", estado:\""
				+ estado + "\", fechaPago:\"" + fechaPago + "\", idSucursal:\"" + idSucursal + "}";
	}


	
	
	
	
}
