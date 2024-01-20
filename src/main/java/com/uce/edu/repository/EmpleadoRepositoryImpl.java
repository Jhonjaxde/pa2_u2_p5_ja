package com.uce.edu.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

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
public class EmpleadoRepositoryImpl implements IEmpleadoRepository {
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public void insertar(Empleado empleado) {
		// TODO Auto-generated method stub
		this.entityManager.persist(empleado);
	}
	@Override
	public Empleado seleccionarPorSalario(BigDecimal salario) {
		Query consulta =
				this.entityManager.createNativeQuery("SELECT * FROM empleado e WHERE e.empl_salario=:salario",Empleado.class);
		consulta.setParameter("salario", salario);
		return (Empleado) consulta.getSingleResult();
	}
	@Override
	public Ciudadano seleccionarPorSalarioT(BigDecimal salario) {
		TypedQuery<Ciudadano> consulta = 
				this.entityManager.createQuery("SELECT c FROM Ciudadano c WHERE c.empleado.salario=:salario", Ciudadano.class);
				consulta.setParameter("salario", salario);
				return consulta.getSingleResult();
	}
	@Override
	public Ciudadano seleccionarPorFecha(LocalDateTime fechaIngreso) {
		TypedQuery<Ciudadano> consulta = 
				this.entityManager.createQuery("SELECT c FROM Ciudadano c WHERE c.empleado.fechaIngreso<:fechaIngreso", Ciudadano.class);
				consulta.setParameter("fechaIngreso", fechaIngreso);
				return consulta.getSingleResult();
	}

}
