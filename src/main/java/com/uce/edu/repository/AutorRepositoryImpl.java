package com.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Ciudadano;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
@Transactional
@Repository
public class AutorRepositoryImpl implements IAutorRepository {
	@PersistenceContext
	private EntityManager entityManager;
	

	@Override
	public Autor seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Autor.class, id);
	}

	@Override
	public void insertar(Autor autor) {
		// TODO Auto-generated method stub
		this.entityManager.persist(autor);
	}

	@Override
	public void actualizar(Autor autor) {
		// TODO Auto-generated method stub
		this.entityManager.merge(autor);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.seleccionar(id));
	}
	@Override
	public List<Autor> seleccionarPorNacionalidad(String nacional) {
		
		CriteriaBuilder myCriteria=this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Autor> myCriteriaQuery=myCriteria.createQuery(Autor.class);
		
		Root<Autor> myFrom=myCriteriaQuery.from(Autor.class);
		Predicate condicionGeneral=null;
		if(nacional.contains("ruso")) {
			 condicionGeneral=myCriteria.equal(myFrom.get("nacional"), nacional); 
		}else if(nacional.contains("ingles")){
			 condicionGeneral=myCriteria.equal(myFrom.get("nacional"), nacional); 
		}else {
			System.out.println("no hay datos");
		}
		
	
		myCriteriaQuery.select(myFrom).where(condicionGeneral);
		
		TypedQuery<Autor> myTypedQuery=this.entityManager.createQuery(myCriteriaQuery);
		
		return myTypedQuery.getResultList();
	}

}
