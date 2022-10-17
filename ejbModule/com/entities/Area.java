package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: Area
 *
 */
@Entity
public class Area implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nombre;

	private static final long serialVersionUID = 1L;

	public Area() {
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

}
