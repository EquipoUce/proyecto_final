package com.uce.edu.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "reserva")
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_reserva")
	@SequenceGenerator(name = "seq_reserva", sequenceName = "seq_reserva", allocationSize = 1)
	@Column(name = "rese_id")
	private Integer id;

	@Column(name = "rese_numero_reserva")
	private String numero;

	@Column(name = "rese_fecha_inicio")
	private LocalDateTime fechaInicio;

	@Column(name = "rese_fecha_fin")
	private LocalDateTime fechaFin;

	@Column(name = "rese_estado")
	private String estado;

	@Column(name = "rese_valor_sub_total")
	private BigDecimal valorSubTotal;

	@Column(name = "rese_valor_ice")
	private BigDecimal valorICE;

	@Column(name = "rese_valor_total_a_pagar")
	private BigDecimal valorTotalAPagar;

	@ManyToOne
	@JoinColumn(name = "rese_id_vehiculo")
	private Vehiculo vehiculo;

	@ManyToOne
	@JoinColumn(name = "rese_id_cliente")
	private Cliente cliente;

	// Setter and Getter
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroReserva() {
		return numero;
	}

	public void setNumeroReserva(String numeroReserva) {
		this.numero = numeroReserva;
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

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public BigDecimal getValorSubTotal() {
		return valorSubTotal;
	}

	public void setValorSubTotal(BigDecimal valorSubTotal) {
		this.valorSubTotal = valorSubTotal;
	}

	public BigDecimal getValorICE() {
		return valorICE;
	}

	public void setValorICE(BigDecimal valorICE) {
		this.valorICE = valorICE;
	}

	public BigDecimal getValorTotalAPagar() {
		return valorTotalAPagar;
	}

	public void setValorTotalAPagar(BigDecimal valorTotalAPagar) {
		this.valorTotalAPagar = valorTotalAPagar;
	}

}
