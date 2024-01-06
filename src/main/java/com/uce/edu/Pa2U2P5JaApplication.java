package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.service.IAlumnoService;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEmpleadoService;
import com.uce.edu.service.IEstudianteService;
import com.uce.edu.service.IHabitacionService;
import com.uce.edu.service.IHotelService;
import com.uce.edu.service.ILibroService;

@SpringBootApplication
public class Pa2U2P5JaApplication implements CommandLineRunner {
	@Autowired
	private ILibroService libroService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5JaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//un libro que tiene dos autores
		//instancias
		Libro lib = new Libro();
		lib.setTitulo("caperucita roja");
		lib.setFechaPublicacion(LocalDateTime.now());
		
		Autor au1 = new Autor();
		au1.setNacional("ruso");
		au1.setNombre("santa claus");
		
		Autor au2 = new Autor();
		au2.setNacional("ingles");
		au2.setNombre("Albert wesker");
		// relaciones
		Set<Libro> listaLibro = new HashSet<Libro>();
		listaLibro.add(lib);
		au1.setLibros(listaLibro);
		au2.setLibros(listaLibro);
		
		Set<Autor> listaAutor = new HashSet<Autor>();
		listaAutor.add(au1);
		listaAutor.add(au2);
		lib.setAutores(listaAutor);
		//insercion 
		this.libroService.guardar(lib);
		
		
		
	}

}
