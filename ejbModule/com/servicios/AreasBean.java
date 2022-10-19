package com.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Area;
import com.exceptions.ServiciosException;

/**
 * Session Bean implementation class AreaBean
 */
@Stateless
public class AreasBean implements AreasBeanRemote {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public AreasBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long crear(Area area) throws ServiciosException {
		try {
			em.persist(area);
			em.flush();
		} catch (PersistenceException e) {
			System.out.println("No se pudo crear el área.");
		}
		return area.getId();
	}

	@Override
	public void actualizar(Area area) throws ServiciosException {
		try {
			em.merge(area);
			em.flush();
		} catch (PersistenceException e) {
			System.out.println("No se pudo actualizar el área.");
		}
	}

	@Override
	public void borrar(Long id) throws ServiciosException {
		try {
			Area area = em.find(Area.class, id);
			em.remove(area);
			em.flush();
		} catch (PersistenceException e) {
			System.out.println("No se pudo borrar el área.");
		}
	}

	@Override
	public List<Area> obtenerTodos() {
		TypedQuery<Area> query = em.createQuery("SELECT a FROM Area a", Area.class);
		return query.getResultList();
	}

	@Override
	public List<Area> obtenerTodos(String filtro) {
		TypedQuery<Area> query = em.createQuery("SELECT a FROM Area a WHERE a.nombre LIKE :nombre", Area.class)
				.setParameter("nombre", filtro);
		return query.getResultList();
	}
}
