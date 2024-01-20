package com.uce.edu.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IEmpleadoRepository;
import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
@Service
public class EmpleadoServiceImpl implements IEmpleadoService {
	@Autowired
	private IEmpleadoRepository empleadoRepository;
	@Override
	public void guardar(Empleado empleado) {
		// TODO Auto-generated method stub
		this.empleadoRepository.insertar(empleado);
	}
	@Override
	public Empleado buscarPorSalario(BigDecimal salario) {
		// TODO Auto-generated method stub
		return this.empleadoRepository.seleccionarPorSalario(salario);
	}
	@Override
	public Ciudadano buscarPorSalarioT(BigDecimal salario) {
		// TODO Auto-generated method stub
		return this.empleadoRepository.seleccionarPorSalarioT(salario);
	}
	@Override
	public Ciudadano buscarPorFecha(LocalDateTime fechaIngreso) {
		// TODO Auto-generated method stub
		return this.empleadoRepository.seleccionarPorFecha(fechaIngreso);
	}

}
