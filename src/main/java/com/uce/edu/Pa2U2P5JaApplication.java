package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.service.IAlumnoService;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEmpleadoService;
import com.uce.edu.service.IEstudianteService;

@SpringBootApplication
public class Pa2U2P5JaApplication implements CommandLineRunner {
	@Autowired
	private ICiudadanoService ciudadanoService;
	@Autowired
	private IEmpleadoService empleadoService;
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5JaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Ciudadano ciu = new Ciudadano();
		ciu.setApellido("ARTEAGA");
		ciu.setNombre("JHON");
		
		Empleado em = new Empleado();
		em.setFechaIngreso(LocalDateTime.now());
		em.setSalario(new BigDecimal(893289239));
		
		em.setCiudadano(this.ciudadanoService.buscar(2));
		ciu.setEmpleado(em);
		
		this.empleadoService.guardar(em);
		this.ciudadanoService.guardar(ciu);
		//System.out.println(this.ciudadanoService.buscar(2));
		
	}

}
