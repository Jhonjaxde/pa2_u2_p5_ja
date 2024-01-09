package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
@Transactional
@Repository
public class LibroRepositoryImpl implements ILibroRepository {
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public Libro seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Libro.class, id);
	}

	@Override
	public void insertar(Libro libro) {
		// TODO Auto-generated method stub
		this.entityManager.persist(libro);
	}

	@Override
	public void actualizar(Libro libro) {
		// TODO Auto-generated method stub
		this.entityManager.merge(libro);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.seleccionar(id));
	}

	@Override
	public void insertar(Libro2 libro2) {
		// TODO Auto-generated method stub
		this.entityManager.persist(libro2);
	}

	@Override
	public Libro seleccionarPorTitulo(String titulo) {
		//Select * from Libro l where l.libr_titulo =?
		//SELECT l FROM Libro l WHERE l.titulo =:variable
		Query myQuery = this.entityManager.createQuery(
				"SELECT l FROM Libro l WHERE l.titulo =:variable");
		myQuery.setParameter("variable",titulo);
		return  (Libro) myQuery.getSingleResult();
	}

}
