package com.uce.edu.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class LibroRepositoryImpl implements ILibroRepository {
	// 1.- Query(JPQL)
	//  1.1 TypedQuery
	//  1.2 NamedQuery
	// 2.- NativeQuery
	// 3.- Criteria API Query
	// cuando un query es importante utilizar en momentos especificos
	//los namedquery solucionan de una manera centralizada(JPQL)le da un nombre al SQL
	//  y cuando se necesite usar se lo llama por el alias en la clase que se lo necesita(entidad)
	//

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
		// Select * from Libro l where l.libr_titulo =?
		// SELECT l FROM Libro l WHERE l.titulo =:variable
		Query myQuery = this.entityManager.createQuery("SELECT l FROM Libro l WHERE l.titulo =:variable");
		myQuery.setParameter("variable", titulo);
		return (Libro) myQuery.getSingleResult();
		
		//otra manera de retornar un solo valor es con el myQuery.getResultList().get(1);
	}

	// para varios resultados
	@Override
	public List<Libro> seleccionarPorFechaPublicacion(LocalDateTime fechaPublicacion) {
		// SELECT * FROM libro l WHERE l.libr_fecha_publicacion>=?
		// SELECT l FROM Libro l WHERE l.fechaPublicacion >=:fecha
		Query myQuery = 
				this.entityManager.createQuery(
						"SELECT l FROM Libro l WHERE l.fechaPublicacion >=:fecha");
		myQuery.setParameter("fecha", fechaPublicacion);
		return (List<Libro>) myQuery.getResultList();
	}

	@Override
	public Libro seleccionarPorTituloT(String titulo) {
		TypedQuery<Libro> myQuery = this.entityManager.createQuery("SELECT l FROM Libro l WHERE l.titulo =:titulo",Libro.class);
		myQuery.setParameter("titulo", titulo);
		return myQuery.getSingleResult();
	}

	@Override
	public List<Libro> seleccionarPorFecha(LocalDateTime fechaPublicacion) {
		TypedQuery<Libro> myQuery = this.entityManager.createQuery("SELECT l FROM Libro l WHERE l.fechaPublicacion >=:fecha", Libro.class);
		myQuery.setParameter("fecha", fechaPublicacion);
		return myQuery.getResultList();
	}

	@Override
	public Libro seleccionarPorTituloNamed(String titulo) {
		TypedQuery<Libro> myQuery = this.entityManager.createNamedQuery("Libro.queryBuscarPorTitulo",Libro.class);
		myQuery.setParameter("titulo", titulo);
		return myQuery.getSingleResult();
	}

	@Override
	public List<Libro> seleccionarPorFechaNamed(LocalDateTime fechaPublicacion) {
		TypedQuery<Libro> myQuery = this.entityManager.createNamedQuery("Libro.queryBuscarPorFecha",Libro.class);
		myQuery.setParameter("fecha", fechaPublicacion);
		return myQuery.getResultList();
	}

}
