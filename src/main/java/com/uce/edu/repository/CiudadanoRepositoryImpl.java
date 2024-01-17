package com.uce.edu.repository;

import java.util.List;

import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Transactional
@Repository
public class CiudadanoRepositoryImpl implements ICiudadanoRepository {
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public void insertar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.entityManager.persist(ciudadano);
	}
	@Override
	public Ciudadano seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Ciudadano.class, id);
	}
	@Override
	public Empleado seleccionarPorCedula(String cedula) {
		TypedQuery<Empleado> consulta = 
		this.entityManager.createQuery("SELECT e FROM Empleado e WHERE e.ciudadano.cedula=:cedula", Empleado.class);
		consulta.setParameter("cedula", cedula);
		return consulta.getSingleResult();
	}
	@Override
	public List<Ciudadano> seleccionarPorCedulaCiu(String cedula) {
		//
		Query consulta =
				this.entityManager.createNativeQuery("SELECT * FROM ciudadano c WHERE c.ciud_cedula=:cedula",Ciudadano.class);
		consulta.setParameter("cedula", cedula);
		return (List<Ciudadano>) consulta.getResultList();
	}
	
	

}
