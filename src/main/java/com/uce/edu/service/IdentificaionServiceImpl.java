package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IIdentificaionRepository;
import com.uce.edu.repository.modelo.Identificacion;
@Service
public class IdentificaionServiceImpl implements IIdentificaionService {
	@Autowired
	private IIdentificaionRepository identificaionRepository;
	@Override
	public Identificacion buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.identificaionRepository.seleccionar(id);
	}

	@Override
	public void guardar(Identificacion identificacion) {
		// TODO Auto-generated method stub
		this.identificaionRepository.insertar(identificacion);
		
	}

	@Override
	public void actualizar(Identificacion identificacion) {
		// TODO Auto-generated method stub
		this.identificaionRepository.actualizar(identificacion);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.identificaionRepository.eliminar(id);
	}

}
