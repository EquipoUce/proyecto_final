package com.uce.edu.repository.modelo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ReservaDTO {
	//datos cliente
	private String cedula;
	private String nombre;
	private String apellido;
	
	//datos vehiculo
	private String placa;
	private String marca;
	
	//datos reserva
	private BigDecimal valorTotalAPagar;
	private String numeroReserva;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;	
	private String estado;

	public ReservaDTO() {
		// TODO Auto-generated constructor stub
	}

	public ReservaDTO(String cedulaCliente, String nombreCliente, String apellidoCliente, String placa, String marca,
			BigDecimal valorTotalAPagar, String numeroReserva, LocalDateTime fechaInicio, LocalDateTime fechaFin,
			String estado) {
		super();
		this.cedula = cedulaCliente;
		this.nombre = nombreCliente;
		this.apellido = apellidoCliente;
		this.placa = placa;
		this.marca = marca;
		this.valorTotalAPagar = valorTotalAPagar;
		this.numeroReserva = numeroReserva;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estado = estado;
	}
	
	

	@Override
	public String toString() {
		return "ReservaDTO [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", placa=" + placa
				+ ", marca=" + marca + ", valorTotalAPagar=" + valorTotalAPagar + ", numeroReserva=" + numeroReserva
				+ ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", estado=" + estado + "]";
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
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

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public BigDecimal getValorTotalAPagar() {
		return valorTotalAPagar;
	}

	public void setValorTotalAPagar(BigDecimal valorTotalAPagar) {
		this.valorTotalAPagar = valorTotalAPagar;
	}

	public String getNumeroReserva() {
		return numeroReserva;
	}

	public void setNumeroReserva(String numeroReserva) {
		this.numeroReserva = numeroReserva;
	}

	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDateTime getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDateTime fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	//Setter and Getter
	
	

}
