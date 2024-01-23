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
	private IEmpleadoService empleadoService;
	@Autowired
	private ICiudadanoService ciudadanoService;
	@Autowired
	private IHabitacionService habitacionService;
	@Autowired
	private IHotelService hotelService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5JaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Criteria API Query 
		
			Ciudadano ciu=this.ciudadanoService.buscarPorApellidoC("Arteaga");
			System.out.println(ciu);

			Ciudadano ciu1=this.ciudadanoService.buscarPorCriteria("Jhon", "Arteaga", "1720368248");
					System.out.println(ciu1);
					
			Ciudadano ciu2=this.ciudadanoService.buscarPorCriteria("Jhon", "Arteaga", "0520368248");
			System.out.println(ciu2);	
			
			//Ciudadano ciu3=this.ciudadanoService.buscarPorCriteria("augusto", "salazar", "0652083905");
			//System.out.println(ciu3);
			
			System.out.println("Criteria API Query AND OR ");
			Ciudadano ciu4=this.ciudadanoService.buscarPorCriteriaAndOr("Jhon", "Arteaga", "1720368248");
			System.out.println(ciu4);
			
			Ciudadano ciu5=this.ciudadanoService.buscarPorCriteriaAndOr("Jhon", "Arteaga", "0520368248");
			System.out.println(ciu5);

	}

}
