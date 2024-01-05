package com.uce.edu.service;

import com.uce.edu.repository.modelo.Identificacion;

public interface IIdentificaionService {
	public Identificacion buscar(Integer id);
	public void guardar(Identificacion identificacion);
	public void actualizar(Identificacion identificacion);
	public void borrar(Integer id);
}
