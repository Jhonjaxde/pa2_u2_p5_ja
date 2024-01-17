package com.uce.edu.repository;


import java.util.List;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

public interface ICiudadanoRepository {
	public void insertar(Ciudadano ciudadano);
	public Ciudadano seleccionar(Integer id);
	public Empleado seleccionarPorCedula(String cedula);
	public List<Ciudadano> seleccionarPorCedulaCiu(String cedula); 
}
