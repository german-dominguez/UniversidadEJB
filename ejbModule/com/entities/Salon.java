package com.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

/**
 * Entity implementation class for Entity: Salon
 *
 */
@Entity
public class Salon implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	private String nombre;
	private int capacidadMax;
	private boolean salonDePracticas;
	@Enumerated
	private Tipo tipo;

	@ManyToOne
	private Area area;

	@OneToMany
	private List<Material> materiales;

	private static final long serialVersionUID = 1L;

	public Salon() {
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

	public int getCapacidadMax() {
		return capacidadMax;
	}

	public void setCapacidadMax(int capacidadMax) {
		this.capacidadMax = capacidadMax;
	}

	public boolean isSalonDePracticas() {
		return salonDePracticas;
	}

	public void setSalonDePracticas(boolean salonDePracticas) {
		this.salonDePracticas = salonDePracticas;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public List<Material> getMateriales() {
		return materiales;
	}

	public void setMateriales(List<Material> materiales) {
		this.materiales = materiales;
	}

}
