package com.uce.edu.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

public interface IEmpleadoRepository {
	public void insertar(Empleado empleado);
	public Empleado seleccionarPorSalario(BigDecimal salario);
	public Ciudadano seleccionarPorSalarioT(BigDecimal salario);
	public Ciudadano seleccionarPorFecha(LocalDateTime fechaIngreso);
}
