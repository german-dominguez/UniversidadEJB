package com.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Area;
import com.entities.Material;
import com.exceptions.ServiciosException;

/**
 * Session Bean implementation class MaterialesBean
 */
@Stateless
public class MaterialesBean implements MaterialesBeanRemote {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public MaterialesBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long crear(Material material) throws ServiciosException {
		try {
			em.persist(material);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo crear el material.");
		}
		return material.getId();
	}

	@Override
	public void actualizar(Material material) throws ServiciosException {
		try {
			em.merge(material);
			em.flush();
		} catch (PersistenceException e) {
			System.out.println("No se pudo actualizar el material.");
		}
	}

	@Override
	public void borrar(Long id) throws ServiciosException {
		try {
			Material material = em.find(Material.class, id);
			em.remove(material);
			em.flush();
		} catch (PersistenceException e) {
			System.out.println("No se pudo borrar el material.");
		}
	}

	@Override
	public List<Material> obtenerTodos() {
		TypedQuery<Material> query = em.createQuery("SELECT m FROM Material m", Material.class);
		return query.getResultList();
	}

	@Override
	public List<Material> obtenerTodos(String filtro) {
		TypedQuery<Material> query = em
				.createQuery("SELECT m FROM Material m WHERE m.nombre LIKE :nombre", Material.class)
				.setParameter("nombre", filtro);
		return query.getResultList();
	}

}
