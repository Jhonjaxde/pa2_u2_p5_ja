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
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5JaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// instancias
		Hotel hot = new Hotel();
		hot.setDireccion("AV.Carapungo");
		hot.setNombre("HOSTAL TREE");
		
		Habitacion hab1 = new Habitacion();
		hab1.setClase("humilde");
		hab1.setNumero("05");
		Habitacion hab2 = new Habitacion();
		hab2.setClase("premium");
		hab2.setNumero("69");
		List<Habitacion> lista = new ArrayList<>();
		lista.add(hab1);
		lista.add(hab2);
		// relaciones 
		hot.setHabitaciones(lista);
		hab1.setHotel(hot);
		hab2.setHotel(hot);
		
		this.hotelService.guardar(hot);
		//System.out.println(this.hotelService.buscar(1));
		
	}

}
