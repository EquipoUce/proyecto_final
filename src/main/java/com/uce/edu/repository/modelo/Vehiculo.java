package com.uce.edu.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	@Column(name="vehi_anio_fabricaion")
	private LocalDateTime anioFabricacion;
	@Column(name="vehi_pais_fabricacion")
	private String paisFabricacion;
	@Column(name="vehi_cilindraje")
	private String cilindraje;
	@Column(name="vehi_avaluo_vehiculo")
	private BigDecimal avaluoVehiculo;
	@Column(name="vehi_avaluo_por_dia")
	private BigDecimal avaluoPorDia;
	
	@OneToMany(mappedBy = "vehiculo")
	private List<Reserva> reservas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}
	public LocalDateTime getAnioFabricacion() {
		return anioFabricacion;
	}

	public void setAnioFabricacion(LocalDateTime anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
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

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public BigDecimal getAvaluoVehiculo() {
		return avaluoVehiculo;
	}

	public void setAvaluoVehiculo(BigDecimal avaluoVehiculo) {
		this.avaluoVehiculo = avaluoVehiculo;
	}

	public BigDecimal getAvaluoPorDia() {
		return avaluoPorDia;
	}

	public void setAvaluoPorDia(BigDecimal avaluoPorDia) {
		this.avaluoPorDia = avaluoPorDia;
	}
	
	

}
