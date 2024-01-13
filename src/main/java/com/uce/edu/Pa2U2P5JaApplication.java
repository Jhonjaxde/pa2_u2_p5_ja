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
import com.uce.edu.repository.modelo.Autor2;
import com.uce.edu.repository.modelo.AutorLibro;
import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;
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
		lib.setTitulo("Programacion avanzada");
		lib.setFechaPublicacion(LocalDateTime.of(2024, 01, 10, 18, 0));
		
		Autor au1 = new Autor();
		au1.setNacional("ruso");
		au1.setNombre("santa claus");
		
		Autor au2 = new Autor();
		au2.setNacional("ingles");
		au2.setNombre("Albert wesker");
		//relaciones
		Set<Libro> listaLibro = new HashSet<>();
		listaLibro.add(lib);
		au1.setLibros(listaLibro);
		//au2.setLibros(listaLibro);
		
		Set<Autor> listaAutor = new HashSet<>();
		listaAutor.add(au1);
		//listaAutor.add(au2);
		lib.setAutores(listaAutor);
		
		/*
		 * AutorLibro autorLibro1 = new AutorLibro(); autorLibro1.setLibro2(lib);
		 * autorLibro1.setAutor2(au1); autorLibro1.setFecha(LocalDateTime.now());
		 * 
		 * 
		 * AutorLibro autorLibro2 = new AutorLibro(); autorLibro2.setLibro2(lib);
		 * autorLibro2.setAutor2(au2); autorLibro2.setFecha(LocalDateTime.now());
		 * 
		 * List<AutorLibro> lista= new ArrayList<>(); lista.add(autorLibro1);
		 * lista.add(autorLibro2); lib.setAutoresLibros(lista);
		 */
		
		
		//insercion 
		//this.libroService.guardar(lib);
		System.out.println("Query");
		Libro libr= this.libroService.buscarPorTitulo("Programacion avanzada");
		System.out.println(libr);
		
		List<Libro> listalibro =  this.libroService.buscarPorFechaPublicacion(LocalDateTime.of(2024, 01, 10, 18, 0));
		for (Libro libro : listalibro) {
			System.out.println(libro);
		}
		System.out.println("TypedQuery");
		Libro libro= this.libroService.buscarPorTituloT("JAVA2");
		System.out.println(libro);
		
		List<Libro> lista =  this.libroService.buscarPorFecha(LocalDateTime.of(2024, 01, 10, 18, 0));
		for (Libro libro1 : lista) {
			System.out.println(libro1);
		}
		System.out.println("NamedQuery");
		Libro libro1= this.libroService.buscarPorTituloNamed("JAVA");
		System.out.println(libro1);
		
		List<Libro> lista1 =  this.libroService.buscarPorFechaNamed(LocalDateTime.of(2024, 01, 10, 18, 0));
		for (Libro libro2 : lista1) {
			System.out.println(libro2);}
	}

}
