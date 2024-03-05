package com.uce.edu.service.TO;

import java.time.LocalDateTime;

public class RangoFechasTO {
	
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	
	public RangoFechasTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RangoFechasTO(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
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
