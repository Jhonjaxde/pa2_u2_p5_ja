package com.uce.edu.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;

public interface ILibroService {
	public Libro buscar(Integer id);
	public void guardar(Libro libro);
	public void actualizar(Libro libro);
	public void borrar(Integer id);
	public void guardar(Libro2 libro2);
	public Libro buscarPorTitulo(String titulo);
	public Libro buscarPorTituloT(String titulo);
	public Libro buscarPorTituloNamed(String titulo);
	public List<Libro> buscarPorFechaPublicacion(LocalDateTime fechaPublicacion);
	public List<Libro> buscarPorFecha(LocalDateTime fechaPublicacion);
	public List<Libro> buscarPorFechaNamed(LocalDateTime fechaPublicacion);
}
