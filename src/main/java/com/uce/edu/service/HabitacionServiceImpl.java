package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IHabitacionRepository;
import com.uce.edu.repository.modelo.Habitacion;
@Service
public class HabitacionServiceImpl implements IHabitacionService {
	@Autowired
	private IHabitacionRepository habitacionRepository;
	@Override
	public Habitacion buscar(Integer id) {
		
		return this.habitacionRepository.seleccionar(id);
	}

	@Override
	public void guardar(Habitacion habitacion) {
		this.habitacionRepository.insertar(habitacion);

	}

	@Override
	public void actualizar(Habitacion habitacion) {
		this.habitacionRepository.actualizar(habitacion);

	}

	@Override
	public void borrar(Integer id) {
		this.habitacionRepository.eliminar(id);

	}

}
