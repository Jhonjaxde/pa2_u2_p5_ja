package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IPersonaRepository;
import com.uce.edu.repository.modelo.Persona;
@Service
public class PersonaServiceImpl implements IPersonaService {
	@Autowired
	private IPersonaRepository personaRepository;
	@Override
	public Persona buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.personaRepository.seleccionar(id);
	}

	@Override
	public void guardar(Persona persona) {
		// TODO Auto-generated method stub
		this.personaRepository.insertar(persona);
	}

	@Override
	public void actualizar(Persona persona) {
		// TODO Auto-generated method stub
		this.personaRepository.actualizar(persona);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.personaRepository.eliminar(id);
	}

}
