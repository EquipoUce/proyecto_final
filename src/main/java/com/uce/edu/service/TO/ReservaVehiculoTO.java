package com.uce.edu.service.TO;

import java.time.LocalDateTime;

public class ReservaVehiculoTO {
	private String placa;
	private String cedulaCliente;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	private String numeroTarjeta;

	public ReservaVehiculoTO() {
		// TODO Auto-generated constructor stub
	}

	public ReservaVehiculoTO(String placa, String cedulaCliente, LocalDateTime fechaInicio, LocalDateTime fechaFin,
			String numero) {
		super();
		this.placa = placa;
		this.cedulaCliente = cedulaCliente;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.numeroTarjeta = numero;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
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

}
