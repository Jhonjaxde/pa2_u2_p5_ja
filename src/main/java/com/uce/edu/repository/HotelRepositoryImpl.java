package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Hotel seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Hotel.class, id);
	}

	@Override
	public void insertar(Hotel hotel) {
		this.entityManager.persist(hotel);

	}

	@Override
	public void actualizar(Hotel hotel) {
		this.entityManager.merge(hotel);

	}

	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(this.seleccionar(id));

	}

}
