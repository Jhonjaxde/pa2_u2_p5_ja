package com.uce.edu.service;

import java.util.List;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

public interface ICiudadanoService {
	public void guardar(Ciudadano ciudadano);
	
	public Ciudadano buscar(Integer id);
	
	public Empleado buscarPorCedula(String cedula);
	
	public List<Ciudadano> buscarPorCedulaCiu(String cedula);
}
