package com.uce.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IHotelRepository;
import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;
@Service
public class HotelServiceImpl implements IHotelService {
	@Autowired
	private IHotelRepository hotelRepository;
	@Override
	public Hotel buscar(Integer id) {
		
		return this.hotelRepository.seleccionar(id);
	}

	@Override
	public void guardar(Hotel hotel) {
		this.hotelRepository.insertar(hotel);

	}

	@Override
	public void actualizar(Hotel hotel) {
		this.hotelRepository.actualizar(hotel);

	}

	@Override
	public void borrar(Integer id) {
		this.hotelRepository.eliminar(id);

	}

	@Override
	public List<Habitacion> buscarPorClase(String clase) {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarPorClase(clase);
	}

	@Override
	public Hotel buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarPorNombre(nombre);
	}

}
