package com.banco.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "t_sucursal")
@XmlRootElement(name = "Sucursal")
public class Sucursal implements Serializable{

	private static final long serialVersionUID = 3657102368414717935L;
	
	@Id 
	@Column(name = "idSucursal", insertable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSucursal;
	
	@Column(name= "nombre")
	private String nombre;
	
	@Column(name= "direccion")
	private String direccion;
	
	@Column(name= "fechaRegistro")
	private String fechaRegistro;
	
	@Column(name= "idBanco")
	private int idBanco;
	
	public Sucursal() {
		// TODO Auto-generated constructor stub
	}
	

	public Sucursal(int idSucursal, String nombre, String direccion, String fechaRegistro, int idBanco) {
		super();
		this.idSucursal = idSucursal;
		this.nombre = nombre;
		this.direccion = direccion;
		this.fechaRegistro = fechaRegistro;
		this.idBanco = idBanco;
	}
	public Sucursal(String nombre, String direccion, String fechaRegistro, int idBanco) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.fechaRegistro = fechaRegistro;
		this.idBanco = idBanco;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public int getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}

	public int getIdBanco() {
		return idBanco;
	}

	public void setIdBanco(int idBanco) {
		this.idBanco = idBanco;
	}

	@Override
	public String toString() {
		return "{idSucursal:\"" + idSucursal + "\", nombre:\"" + nombre + "\", direccion:\"" + direccion
				+ "\", fechaRegistro:\"" + fechaRegistro + "\", idBanco:\"" + idBanco + "}";
	}

	
	
}
