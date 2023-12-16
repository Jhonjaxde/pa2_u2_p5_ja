package com.uce.edu;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.service.IAlumnoService;
import com.uce.edu.service.IEstudianteService;

@SpringBootApplication
public class Pa2U2P5JaApplication implements CommandLineRunner {
	@Autowired
	private IEstudianteService estudianteService;
	@Autowired
	private IAlumnoService alumnoService;
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5JaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		 * // TODO Auto-generated method stub Estudiante estu= new Estudiante();
		 * estu.setApellido("CHILES"); estu.setCedula("1720368248");
		 * estu.setFechaNacimiento(LocalDateTime.of(2001, 5, 3, 12, 0));
		 * estu.setNombre("JAIRO"); //this.estudianteService.guardar(estu);
		 * System.out.println(this.estudianteService.buscar(12));
		 * //estu.setNombre("JHONCITO"); //this.estudianteService.actualizar(estu);
		 * //this.estudianteService.borrar(9);
		 */	
		
		//Alumno au = new Alumno();
		//au.setNombre("EMILIO");
		//this.alumnoService.guardar(au);
		//System.out.println(this.alumnoService.buscar(4));
		//Alumno aul = this.alumnoService.buscar(4);
		//aul.setNombre("PERANCIO");
		//this.alumnoService.actualizar(aul);
		this.alumnoService.borrar(4);
		
	}

}
