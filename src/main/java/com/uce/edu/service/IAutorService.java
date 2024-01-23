package com.uce.edu.service;

import java.util.List;

import com.uce.edu.repository.modelo.Autor;

public interface IAutorService {
	public Autor buscar(Integer id);
	public void guardar(Autor autor);
	public void actualizar(Autor autor);
	public void borrar(Integer id);
	public List<Autor> buscarPorNacionalidad(String nacional);
}
