package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IHabitacionRepository;
import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;
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

	@Override
	public Hotel buscarDireccion(String direccion) {
		// TODO Auto-generated method stub
		return this.habitacionRepository.seleccionarDireccion(direccion);
	}

	@Override
	public Habitacion buscarPorClase(String clase) {
		// TODO Auto-generated method stub
		return this.habitacionRepository.seleccionarPorClase(clase);
	}

}
