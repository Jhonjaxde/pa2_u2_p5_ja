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
		//1.-
		Hotel ho = new Hotel();
		ho.setDireccion("carapungo");
		ho.setNombre("hostila");
		
		
		Habitacion hab= new Habitacion();
		hab.setNumero("2");
		hab.setClase("premium");
		List<Habitacion> lista = new ArrayList<>();
		lista.add(hab);
		
		
		ho.setHabitaciones(lista);
		hab.setHotel(ho);
		
		//this.habitacionService.guardar(hab);
		//System.out.println(this.habitacionService.buscarDireccion("carapungo"));
		//System.out.println(this.hotelService.buscarPorClase("premium"));
		//System.out.println(this.hotelService.buscarPorNombre("hostila"));
		//System.out.println(this.habitacionService.buscarPorClase("premium"));
		
		
		//1
		
		Ciudadano ciu = new Ciudadano();
		ciu.setApellido("holay");
		ciu.setCedula("122");
		ciu.setNombre("aldon");
		Empleado emp = new Empleado();
		emp.setFechaIngreso(LocalDateTime.now());
		emp.setSalario(new BigDecimal(2000));
		
		ciu.setEmpleado(emp);
		emp.setCiudadano(ciu);
		
		//this.empleadoService.guardar(emp);
		
		//this.ciudadanoService.guardar(ciu);
		//System.out.println(this.ciudadanoService.buscarPorNombreT("aldon"));
		//System.out.println(this.ciudadanoService.buscarPorApellido("holay"));
		//System.out.println(this.ciudadanoService.buscarPorApellido("holay"));
		System.out.println(this.empleadoService.buscarPorFecha(LocalDateTime.of(2024, 2, 1, 20, 05)));
	}

}
