package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Persona;

public interface IPersonaRepository {
	public Persona seleccionar(Integer id);
	public void insertar(Persona persona);
	public void actualizar(Persona persona);
	public void eliminar(Integer id);
}
