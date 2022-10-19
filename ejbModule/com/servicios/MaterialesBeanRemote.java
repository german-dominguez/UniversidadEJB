package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Material;
import com.exceptions.ServiciosException;

@Remote
public interface MaterialesBeanRemote {
	Long crear(Material material) throws ServiciosException;

	void actualizar(Material material) throws ServiciosException;

	void borrar(Long id) throws ServiciosException;

	List<Material> obtenerTodos();

	List<Material> obtenerTodos(String filtro);
}
