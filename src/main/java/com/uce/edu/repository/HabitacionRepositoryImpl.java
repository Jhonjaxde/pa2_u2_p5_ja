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
public class HabitacionRepositoryImpl implements IHabitacionRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public Habitacion seleccionar(Integer id) {
		
		return this.entityManager.find(Habitacion.class, id);
	}

	@Override
	public void insertar(Habitacion habitacion) {
		
		this.entityManager.persist(habitacion);
	}

	@Override
	public void actualizar(Habitacion habitacion) {
		this.entityManager.merge(habitacion);
	}

	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(this.seleccionar(id));

	}

	@Override
	public Hotel seleccionarDireccion(String direccion) {
		TypedQuery<Hotel> consulta= 
				this.entityManager.createQuery("SELECT ha FROM Habitacion ha WHERE ha.hotel.direccion=:direccion ", Hotel.class);
		consulta.setParameter("direccion", direccion);
		return consulta.getSingleResult();
	}

	@Override
	public Habitacion seleccionarPorClase(String clase) {
		Query consulta =
				this.entityManager.createNativeQuery("SELECT * FROM habitacion ha WHERE ha.hab_clase=:clase",Habitacion.class);
		consulta.setParameter("clase", clase);
		return (Habitacion) consulta.getSingleResult();
	}

}
