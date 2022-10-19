package com.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Area;
import com.entities.Material;
import com.entities.Salon;
import com.exceptions.ServiciosException;

/**
 * Session Bean implementation class SalonesBean
 */
@Stateless
public class SalonesBean implements SalonesBeanRemote {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public SalonesBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long crear(Salon salon) throws ServiciosException {
		try {
			em.persist(salon);
			em.flush();
		} catch (PersistenceException e) {
			System.out.println("No se pudo crear el salón.");
		}
		return salon.getId();
	}

	@Override
	public void actualizar(Salon salon) throws ServiciosException {
		try {
			em.merge(salon);
			em.flush();
		} catch (PersistenceException e) {
			System.out.println("No se pudo actualizar el salón.");
		}
	}

	@Override
	public void borrar(Long id) throws ServiciosException {
		try {
			Salon salon = em.find(Salon.class, id);
			em.remove(salon);
			em.flush();
		} catch (PersistenceException e) {
			System.out.println("No se pudo borrar el salón.");
		}
	}

	@Override
	public void asignarArea(Long idSalon, Long idArea) throws ServiciosException {
		try {
			Salon salon = em.find(Salon.class, idSalon);
			salon.setArea(em.find(Area.class, idArea));
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo asignar el área al salón.");
		}
	}

	@Override
	public void asignarMaterial(Long idSalon, Long idMaterial) throws ServiciosException {
		try {
			Salon salon = em.find(Salon.class, idSalon);
			salon.getMateriales().add(em.find(Material.class, idMaterial));
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo asignar el material al salón.");
		}
	}

	@Override
	public List<Salon> obtenerPorArea(String area) {
		TypedQuery<Salon> query = em.createQuery("SELECT s FROM Salon s WHERE s.area.nombre LIKE :area", Salon.class)
				.setParameter("area", area);
		return query.getResultList();
	}

}
