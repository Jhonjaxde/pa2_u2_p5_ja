package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Identificacion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class IdentificaionRepositoryImpl implements IIdentificaionRepository{
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Identificacion seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Identificacion.class, id);
	}

	@Override
	public void insertar(Identificacion Identificacion) {
		// TODO Auto-generated method stub
		this.entityManager.persist(Identificacion);
	}

	@Override
	public void actualizar(Identificacion Identificacion) {
		// TODO Auto-generated method stub
		this.entityManager.merge(Identificacion);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		//Estudiante e = this.seleccionar(id);
		this.entityManager.remove(this.seleccionar(id));
	}
}
