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
import com.uce.edu.service.IAutorService;
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
	@Autowired
	private IAutorService autorService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5JaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//dos libros que tiene un autor
		//instancias
		Libro lib = new Libro();
		lib.setTitulo("La Divina Comedia");
		lib.setFechaPublicacion(LocalDateTime.of(1472, 12, 12, 12, 02));
		
		Libro lib1 = new Libro();
		lib1.setTitulo("Infierno ");
		lib1.setFechaPublicacion(LocalDateTime.now());
		
		Autor au = new Autor();
		au.setNacional("italiano");
		au.setNombre("Dante Alighieri");
		
		// relaciones
		Set<Libro> listaLibro = new HashSet<Libro>();
		listaLibro.add(lib);
		listaLibro.add(lib1);
		au.setLibros(listaLibro);
		
		Set<Autor> listaAutor = new HashSet<Autor>();
		listaAutor.add(au);
		
		lib.setAutores(listaAutor);
		//insercion 
		//this.libroService.guardar(lib);
		//Libro li = this.libroService.buscar(2);
		//li.setTitulo("Infierno de Dante");
		
		//this.libroService.actualizar(li);
		
		this.autorService.borrar(3);
		
		
	}

}
