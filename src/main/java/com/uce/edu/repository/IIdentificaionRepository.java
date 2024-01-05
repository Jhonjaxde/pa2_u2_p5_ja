package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Identificacion;

public interface IIdentificaionRepository {
	public Identificacion seleccionar(Integer id);
	public void insertar(Identificacion identificacion);
	public void actualizar(Identificacion identificacion);
	public void eliminar(Integer id);
}
