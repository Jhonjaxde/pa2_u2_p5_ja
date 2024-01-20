package com.uce.edu.repository;

import java.util.List;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;

public interface IHotelRepository {
	public Hotel seleccionar(Integer id);
	public void insertar(Hotel hotel );
	public void actualizar(Hotel hotel );
	public void eliminar(Integer id);
	public List<Habitacion> seleccionarPorClase(String clase);
	public Hotel seleccionarPorNombre(String nombre);
	
}
