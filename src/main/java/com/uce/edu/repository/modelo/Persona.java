package com.uce.edu.repository.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "persona")
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_persona")
	@SequenceGenerator(name= "seq_persona",sequenceName = "seq_persona",allocationSize = 1)
	@Column(name = "per_id")
	private Integer id;
	@Column(name = "per_nombre")
	private String nombre;
	@Column(name = "per_apellido")
	private String apellido;
	@OneToOne(mappedBy = "persona",cascade = CascadeType.ALL)
	private Identificacion identificacion;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Identificacion getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(Identificacion identificacion) {
		this.identificacion = identificacion;
	}
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", identificacion="
				+ identificacion + "]";
	}
	
	
}
