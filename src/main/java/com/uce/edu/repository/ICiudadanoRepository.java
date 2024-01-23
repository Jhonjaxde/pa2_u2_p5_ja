package com.uce.edu.repository;

import java.math.BigDecimal;
import java.util.List;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

public interface ICiudadanoRepository {
	public void insertar(Ciudadano ciudadano);

	public Ciudadano seleccionar(Integer id);
	
	public void actualizar(Ciudadano ciudadano);

	public Empleado seleccionarPorCedula(String cedula);

	public List<Ciudadano> seleccionarPorCedulaCiu(String cedula);

	public List<Ciudadano> seleccionarPorNombre(String nombre);

	public Empleado seleccionarPorApellido(String apellido);

	public Empleado seleccionarPorNombreT(String nombre);
	public Ciudadano seleccionarPorApellidoC(String apellido);

	// funcionalidad que cuando sea el ciudadano de pichincha lo busque por nombre
	// cuando sea de cotopaxi lo budque por apellido
	// cuando no sea ninguna ni de cotopaxi ni pichincha lo busque por cedula
	public Ciudadano seleccionarPorCriteria(String nombre, String apellido, String cedula);

	public Ciudadano seleccionarPorCriteriaAndOr(String nombre, String apellido, String cedula);
}
