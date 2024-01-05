package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Persona;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PersonaRepositoryImpl implements IPersonaRepository{
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Persona seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Persona.class, id);
	}

	@Override
	public void insertar(Persona persona) {
		// TODO Auto-generated method stub
		this.entityManager.persist(persona);
	}

	@Override
	public void actualizar(Persona persona) {
		// TODO Auto-generated method stub
		this.entityManager.merge(persona);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		//Estudiante e = this.seleccionar(id);
		this.entityManager.remove(this.seleccionar(id));
	}
}
