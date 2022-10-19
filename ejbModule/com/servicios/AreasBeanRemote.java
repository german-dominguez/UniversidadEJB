package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Area;
import com.exceptions.ServiciosException;

@Remote
public interface AreasBeanRemote {
	Long crear(Area area) throws ServiciosException;

	void actualizar(Area area) throws ServiciosException;

	void borrar(Long id) throws ServiciosException;

	List<Area> obtenerTodos();

	List<Area> obtenerTodos(String filtro);
}
