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
import com.uce.edu.repository.modelo.Identificacion;
import com.uce.edu.repository.modelo.Persona;
import com.uce.edu.service.IAlumnoService;
import com.uce.edu.service.IIdentificaionService;
import com.uce.edu.service.IPersonaService;
import com.uce.edu.service.IEstudianteService;

@SpringBootApplication
public class Pa2U2P5JaApplication implements CommandLineRunner {
	@Autowired
	private IPersonaService personaService;
	@Autowired
	private IIdentificaionService identificaionService;
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5JaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Persona pe = new Persona();
		pe.setNombre("Jairo");
		pe.setApellido("Arteaga");
		
		Identificacion id = new Identificacion();
		id.setNumeroId("1720786327");
		id.setFechaCreacion(LocalDateTime.now());
		
		//relacioness
		pe.setIdentificacion(id);
		id.setPersona(pe);
		
		this.personaService.guardar(pe);
		System.out.println(this.personaService.buscar(1));
		
	}

}
