package com.uce.edu.service;

import com.uce.edu.repository.modelo.Persona;

public interface IPersonaService {
	public Persona buscar(Integer id);
	public void guardar(Persona persona);
	public void actualizar(Persona persona);
	public void borrar(Integer id);
}
