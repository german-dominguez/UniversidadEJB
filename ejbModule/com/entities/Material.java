package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: Material
 *
 */
@Entity
public class Material implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nombre;
	private String descripcion;

	private static final long serialVersionUID = 1L;

	public Material() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
