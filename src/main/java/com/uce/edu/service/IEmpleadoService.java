package com.uce.edu.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

public interface IEmpleadoService {
	public void guardar(Empleado empleado);
	public Empleado buscarPorSalario(BigDecimal salario);
	public Ciudadano buscarPorSalarioT(BigDecimal salario);
	public Ciudadano buscarPorFecha(LocalDateTime fechaIngreso);
}
