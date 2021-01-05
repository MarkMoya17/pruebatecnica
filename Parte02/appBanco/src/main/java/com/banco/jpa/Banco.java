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
@Table(name = "t_banco")
@XmlRootElement(name = "Banco")
public class Banco implements Serializable{

	private static final long serialVersionUID = -2008248382990421912L;
	
	@Id 
	@Column(name = "idBanco", insertable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBanco;
	
	@Column(name= "nombre")
	private String nombre;
	
	@Column(name= "direccion")
	private String direccion;
	
	@Column(name= "fechaRegistro")
	private String fechaRegistro;
	
	public Banco() {
		// TODO Auto-generated constructor stub
	}

	public Banco(int idBanco, String nombre, String direccion, String fechaRegistro) {
		super();
		this.idBanco = idBanco;
		this.nombre = nombre;
		this.direccion = direccion;
		this.fechaRegistro = fechaRegistro;
	}

	public Banco(String nombre, String direccion, String fechaRegistro) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.fechaRegistro = fechaRegistro;
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

	public int getIdBanco() {
		return idBanco;
	}

	public void setIdBanco(int idBanco) {
		this.idBanco = idBanco;
	}

	@Override
	public String toString() {
		return "{idBanco:\"" + idBanco + "\", nombre:\"" + nombre + "\", direccion:\"" + direccion
				+ "\", fechaRegistro:\"" + fechaRegistro + "}";
	}

	


	
}
