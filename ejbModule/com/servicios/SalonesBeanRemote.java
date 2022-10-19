package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Salon;
import com.exceptions.ServiciosException;

@Remote
public interface SalonesBeanRemote {
	Long crear(Salon salon) throws ServiciosException;

	void actualizar(Salon salon) throws ServiciosException;

	void borrar(Long id) throws ServiciosException;

	void asignarArea(Long idSalon, Long idArea) throws ServiciosException;

	void asignarMaterial(Long idSalon, Long idMaterial) throws ServiciosException;

	List<Salon> obtenerPorArea(String area);
}
