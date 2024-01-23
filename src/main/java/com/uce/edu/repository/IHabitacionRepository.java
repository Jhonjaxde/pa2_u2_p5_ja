package com.uce.edu.repository;

import java.util.List;

import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;

public interface IHabitacionRepository {
	public Habitacion seleccionar(Integer id);
	public void insertar(Habitacion habitacion );
	public void actualizar(Habitacion habitacion );
	public void eliminar(Integer id);
	public Hotel seleccionarDireccion(String direccion);
	public Habitacion seleccionarPorClase(String clase);
	public List<Habitacion> seleccionarPorNumero(String numero);
	public List<Habitacion> seleccionarPorClaseC(String clase,String numero) ;
	
}
