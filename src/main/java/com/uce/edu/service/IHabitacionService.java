package com.uce.edu.service;

import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;

public interface IHabitacionService {
	public Habitacion buscar(Integer id);
	public void guardar(Habitacion habitacion );
	public void actualizar(Habitacion habitacion );
	public void borrar(Integer id);
	public Hotel buscarDireccion(String direccion);
	public Habitacion buscarPorClase(String clase);
}
