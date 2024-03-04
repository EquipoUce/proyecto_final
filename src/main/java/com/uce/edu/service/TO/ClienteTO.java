package com.uce.edu.service.TO;

import java.time.LocalDateTime;

public class ClienteTO {
	private String cedula;
	private String apellido;
	private String nombre;
	private LocalDateTime fechaNacimiento;
	private String registro;
	private String genero;

	public ClienteTO() {
		super();
	}

	public ClienteTO(String cedula, String apellido, String nombre, LocalDateTime fechaNacimiento, String registro,
			String genero) {
		super();
		this.cedula = cedula;
		this.apellido = apellido;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.registro = registro;
		this.genero = genero;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}
