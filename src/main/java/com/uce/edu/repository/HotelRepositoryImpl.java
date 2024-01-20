package com.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
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

	@Override
	public List<Habitacion> seleccionarPorClase(String clase) {
		TypedQuery<Habitacion> consulta= 
				this.entityManager.createQuery("SELECT ho FROM Hotel ho WHERE ho.habitaciones.clase=:clase ", Habitacion.class);
		consulta.setParameter("clase", clase);
		return consulta.getResultList();
	}

	@Override
	public Hotel seleccionarPorNombre(String nombre) {
		Query consulta =
				this.entityManager.createNativeQuery("SELECT * FROM hotel ho WHERE ho.hot_nombre=:nombre",Hotel.class);
		consulta.setParameter("nombre", nombre);
		return (Hotel) consulta.getSingleResult();
	}

}
