package com.uce.edu.service.TO;

import java.math.BigDecimal;

public class VehiculoTO {
	private String placa;
	private String modelo;
	private String marca;
	private String anioFabricacion;
	private String paisFabricacion;
	private String cilindraje;
	private BigDecimal avaluo;
	private BigDecimal valorDiario;
	private String estado;

	public VehiculoTO() {
		super();
	}

	public VehiculoTO(String placa, String modelo, String marca, String anioFabricacion, String paisFabricacion,
			String cilindraje, BigDecimal avaluo, BigDecimal valorDiario, String estado) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.marca = marca;
		this.anioFabricacion = anioFabricacion;
		this.paisFabricacion = paisFabricacion;
		this.cilindraje = cilindraje;
		this.avaluo = avaluo;
		this.valorDiario = valorDiario;
		this.estado = estado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	public String getPaisFabricacion() {
		return paisFabricacion;
	}

	public void setPaisFabricacion(String paisFabricacion) {
		this.paisFabricacion = paisFabricacion;
	}

	public String getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(String cilindraje) {
		this.cilindraje = cilindraje;
	}

	public BigDecimal getAvaluo() {
		return avaluo;
	}

	public void setAvaluo(BigDecimal avaluo) {
		this.avaluo = avaluo;
	}

	public BigDecimal getValorDiario() {
		return valorDiario;
	}

	public void setValorDiario(BigDecimal valorDiario) {
		this.valorDiario = valorDiario;
	}

}
