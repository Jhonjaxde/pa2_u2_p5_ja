package com.uce.edu.service;

import java.math.BigDecimal;
import java.util.List;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

public interface ICiudadanoService {
	public void guardar(Ciudadano ciudadano);

	public Ciudadano buscar(Integer id);
	public void actualizar(Ciudadano ciudadano);

	public Empleado buscarPorCedula(String cedula);

	public List<Ciudadano> buscarPorCedulaCiu(String cedula);

	public List<Ciudadano> buscarPorNombre(String nombre);

	public Empleado buscarPorApellido(String apellido);

	public Empleado buscarPorNombreT(String nombre);

	public Ciudadano buscarPorApellidoC(String apellido);

	public Ciudadano buscarPorCriteria(String nombre, String apellido, String cedula);

	public Ciudadano buscarPorCriteriaAndOr(String nombre, String apellido, String cedula);
}