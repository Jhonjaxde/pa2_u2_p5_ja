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
	private IEmpleadoService empleadoService;
	@Autowired
	private ICiudadanoService ciudadanoService;
	@Autowired
	private IHabitacionService habitacionService;
	@Autowired
	private IHotelService hotelService;
	
	@Autowired
	private IAutorService autorService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5JaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Criteria API Query 
		
		Hotel ho = new Hotel();
		ho.setDireccion("calderon");
		ho.setNombre("hostelito");
		
		Habitacion ha = new Habitacion();
		ha.setClase("humilde");
		ha.setNumero("3");
		
		Habitacion ha1 = new Habitacion();
		ha1.setClase("premuim");
		ha1.setNumero("4");
		
		List<Habitacion> lista = new ArrayList<>();
		lista.add(ha);
		lista.add(ha1);
		ho.setHabitaciones(lista);
		ha.setHotel(ho);
		ha1.setHotel(ho);
		
		//this.habitacionService.guardar(ha1);
		
		
		
		//System.out.println(this.habitacionService.buscarPorNumero("2"));
		//System.out.println(this.habitacionService.buscarPorClaseC("humilde", "2"));
		System.out.println(this.autorService.buscarPorNacionalidad("ingles"));
		System.out.println(this.autorService.buscarPorNacionalidad("ruso"));
		
	}

}
