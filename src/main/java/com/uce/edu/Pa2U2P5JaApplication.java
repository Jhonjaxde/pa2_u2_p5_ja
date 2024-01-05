package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;
import com.uce.edu.service.IAlumnoService;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEmpleadoService;
import com.uce.edu.service.IEstudianteService;
import com.uce.edu.service.IHabitacionService;
import com.uce.edu.service.IHotelService;

@SpringBootApplication
public class Pa2U2P5JaApplication implements CommandLineRunner {
	
	@Autowired
	private IHotelService hotelService;
	@Autowired
	private IHabitacionService habitacionService;
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5JaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// instancias
		Hotel hot = new Hotel();
		hot.setDireccion("Av. quitus");
		hot.setNombre("HOTEL LUNA");
		
		Habitacion hab1 = new Habitacion();
		hab1.setClase("barato");
		hab1.setNumero("1");
		Habitacion hab2 = new Habitacion();
		hab2.setClase("caro");
		hab2.setNumero("34");
		
		Habitacion hab3 = new Habitacion();
		hab3.setClase("caro");
		hab3.setNumero("41");
		
		Habitacion hab4 = new Habitacion();
		hab4.setClase("barato");
		hab4.setNumero("11");
		List<Habitacion> lista = new ArrayList<>();
		lista.add(hab1);
		lista.add(hab2);
		lista.add(hab3);
		lista.add(hab4);
		// relaciones 
		hot.setHabitaciones(lista);
		hab1.setHotel(hot);
		hab2.setHotel(hot);
		hab3.setHotel(hot);
		hab4.setHotel(hot);
		//this.hotelService.guardar(hot);
		System.out.println(this.habitacionService.buscar(1));
		
		
	}

}
