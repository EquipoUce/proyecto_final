package com.uce.edu.repository.modelo.dto;

import java.math.BigDecimal;

public class VehiculoDTO {
	private String placa;
	private String modelo;
	private String marca;
	private String anioFabricacion;
	private String estado;
	private BigDecimal valorPorDia;

	public VehiculoDTO() {
		// TODO Auto-generated constructor stub
	}

	public VehiculoDTO(String placa, String modelo, String marca, String anioFabricacion, String estado,
			BigDecimal valorPorDia) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.marca = marca;
		this.anioFabricacion = anioFabricacion;
		this.estado = estado;
		this.valorPorDia = valorPorDia;
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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getAnioFabricacion() {
		return anioFabricacion;
	}

	public void setAnioFabricacion(String anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public BigDecimal getValorPorDia() {
		return valorPorDia;
	}

	public void setValorPorDia(BigDecimal valorPorDia) {
		this.valorPorDia = valorPorDia;
	}
	
	

}
