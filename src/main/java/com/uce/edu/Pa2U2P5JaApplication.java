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
		Libro2 lib = new Libro2();
		lib.setTitulo("caperucita roja");
		lib.setFechaPublicacion(LocalDateTime.now());
		
		Autor2 au1 = new Autor2();
		au1.setNacional("ruso");
		au1.setNombre("santa claus");
		
		Autor2 au2 = new Autor2();
		au2.setNacional("ingles");
		au2.setNombre("Albert wesker");
		// relaciones
		//List<Libro2> listaLibro = new ArrayList<Libro2>();
		//listaLibro.add(lib);
		//au1.setLibros(listaLibro);
		//au2.setLibros(listaLibro);
		
		List<Autor2> listaAutor = new ArrayList<Autor2>();
		listaAutor.add(au1);
		listaAutor.add(au2);
		
		
		AutorLibro autorLibro1 = new AutorLibro();
		autorLibro1.setLibro2(lib);
		autorLibro1.setAutor2(au1);
		autorLibro1.setFecha(LocalDateTime.now());
		
		
		AutorLibro autorLibro2 = new AutorLibro();
		autorLibro2.setLibro2(lib);
		autorLibro2.setAutor2(au2);
		autorLibro2.setFecha(LocalDateTime.now());
		
		List<AutorLibro> lista= new ArrayList<>();
		lista.add(autorLibro1);
		lista.add(autorLibro2);
		
		lib.setAutoresLibros(lista);
		
		//lib.setAutoresLibros(listaAutor);
		//insercion 
		//this.libroService.guardar(lib);
		Libro libro= this.libroService.buscarPorTitulo("caperucita roja");
		System.out.println(libro);
		
		
	}

}
