package com.uce.edu.service.TO;

public class ReservaEmpleadoTO {
	private String placa;
	private String modelo;
	private String estado;
	private String fecha; //UNIR ANTES DE CREAR EL OBJETO
	private String cedula;
	private String numeroReserva;

	public ReservaEmpleadoTO() {
		// TODO Auto-generated constructor stub
	}

	public ReservaEmpleadoTO(String placa, String modelo, String estado, String fecha, String cedula, String numeroReserva) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.estado = estado;
		this.fecha = fecha;
		this.cedula = cedula;
		this.numeroReserva = numeroReserva;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNumeroReserva() {
		return numeroReserva;
	}

	public void setNumeroReserva(String numeroReserva) {
		this.numeroReserva = numeroReserva;
	}
	
	

}
