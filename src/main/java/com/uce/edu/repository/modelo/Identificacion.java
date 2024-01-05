package com.uce.edu.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "identificacion")
public class Identificacion {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_identificacion")
	@SequenceGenerator(name= "seq_identificacion",sequenceName = "seq_identificacion",allocationSize = 1)
	@Column(name = "iden_id")
	private Integer id;
	@Column(name = "iden_numeroId")
	private String numeroId;
	@Column(name = "iden_fechaCreacion")
	private LocalDateTime fechaCreacion;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "iden_id_persona")
	private Persona persona;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroId() {
		return numeroId;
	}

	public void setNumeroId(String numeroId) {
		this.numeroId = numeroId;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	
	
	
	
}
