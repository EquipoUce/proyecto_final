package com.uce.edu.repository.modelo;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name= "vehiculo")
public class Vehiculo {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_vehiculo")
	@SequenceGenerator(name = "seq_vehiculo", sequenceName = "seq_vehiculo", allocationSize = 1)
	@Column(name="vehi_id")
	private Integer id;
	
	@Column(name="vehi_placa")
	private String placa;
	
	@Column(name="vehi_modelo")
	private String modelo;
	
	@Column(name="vehi_marca")
	private String marca;
	
	@Column(name="vehi_anio_fabricacion")
	private String anioFabricacion;
	
	@Column(name="vehi_pais_fabricacion")
	private String paisFabricacion;
	
	@Column(name="vehi_cilindraje")
	private String cilindraje;
	
	@Column(name="vehi_avaluo_vehiculo")
	private BigDecimal avaluoVehiculo;
	
	@Column(name="vehi_valor_por_dia")
	private BigDecimal valorPorDia;
	
	@Column(name = "vehi_estado")
	private String estado;
	
	@OneToMany(mappedBy = "vehiculo")
	private List<Reserva> reservas;

	//Setter and Getter
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public BigDecimal getAvaluoVehiculo() {
		return avaluoVehiculo;
	}

	public void setAvaluoVehiculo(BigDecimal avaluoVehiculo) {
		this.avaluoVehiculo = avaluoVehiculo;
	}

	public BigDecimal getValorPorDia() {
		return valorPorDia;
	}

	public void setValorPorDia(BigDecimal valorPorDia) {
		this.valorPorDia = valorPorDia;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public String getAnioFabricacion() {
		return anioFabricacion;
	}

	public void setAnioFabricacion(String anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
	}
	
	

}
