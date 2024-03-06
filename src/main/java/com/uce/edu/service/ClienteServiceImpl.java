package com.uce.edu.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IClienteRepository;
import com.uce.edu.repository.IReservaRepository;
import com.uce.edu.repository.IVehiculoRepository;
import com.uce.edu.repository.modelo.Cliente;
import com.uce.edu.repository.modelo.Reserva;
import com.uce.edu.repository.modelo.Vehiculo;
import com.uce.edu.repository.modelo.dto.VehiculoDTO;
import com.uce.edu.service.TO.ClienteTO;
import com.uce.edu.service.TO.ReservaVehiculoTO;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class ClienteServiceImpl implements IClienteService {
	@Autowired
	private IClienteRepository clienteRepository;

	@Autowired
	private IVehiculoRepository vehiculoRepository;

	@Autowired
	private IReservaRepository reservaRepository;

	@Override
	public Cliente buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.clienteRepository.seleccionarPorCedula(cedula);
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void guardar(ClienteTO cliente) {
		Cliente clie = new Cliente();
		clie.setApellido(cliente.getApellido());
		clie.setCedula(cliente.getCedula());
		clie.setFechaNacimiento(cliente.getFechaNacimiento());
		clie.setGenero(cliente.getGenero());
		clie.setNombre(cliente.getNombre());
		clie.setRegistro("Cliente");
		this.clienteRepository.insertar(clie);
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public String reservarVehiculo(ReservaVehiculoTO reservaV) {
		String cedula = reservaV.getCedulaCliente();
		String placa = reservaV.getPlaca();
		LocalDateTime fechaInicio = reservaV.getFechaInicio();
		LocalDateTime fechaFin = reservaV.getFechaFin();

		// TODO Auto-generated method stub
		Reserva rese = new Reserva();
		Reserva reseC = new Reserva();
		Cliente clie = this.clienteRepository.seleccionarPorCedula(cedula);
		Vehiculo vehi = this.vehiculoRepository.seleccionarPorPlaca(placa);
		List<Reserva> listaR = this.reservaRepository.seleccionarTodos();
		System.out.println("placa enviada: " + placa);
		System.out.println("fechas enviada inicio: " + fechaInicio);
		System.out.println("fechas envida fin: " + fechaFin);
		System.out.println("elementos lista Reservas: " + listaR.size());
		
		List<Boolean> validar = new ArrayList<>();
		Boolean total = false;

		if (reservaV.getNumeroTarjeta() != " ") {

			if (listaR.isEmpty() != true) {
				for (Reserva r : listaR) {
					if (r.getVehiculo().getPlaca().equals(vehi.getPlaca())) {
						// si esta en la reserva
						System.out.println("si hay un vehiculo con esa placa en la reserva");

						if ((fechaInicio.isAfter(r.getFechaFin()) && fechaFin.isAfter(r.getFechaFin()))) { // ||//
																											// (fechaInicio.isBefore(r.getFechaInicio())fechaFin.isBefore(r.getFechaInicio()))
							System.out.println("cumple rango -inf");
							System.out.println("cumple rango +inf");
							System.out.println("cumple con un rango valido");
							validar.add(true);
							System.out.println("true");
							reseC = this.reservaRepository.seleccionarPorNumeroReserva(r.getNumeroReserva());
						} else {
							if (fechaInicio.isBefore(r.getFechaFin()) && fechaFin.isBefore(r.getFechaFin())) {
								validar.add(true);
								reseC = this.reservaRepository.seleccionarPorNumeroReserva(r.getNumeroReserva());
							} else {
								validar.add(false);
								System.out.println("false");
								reseC = this.reservaRepository.seleccionarPorNumeroReserva(r.getNumeroReserva());
							}
						}
					} else {
						// no esta en reserva es decir no hay ninguna placa similar
						System.out.println("si hay un vehiculo con esa placa en la reserva NEGATIVO");
						System.out.println("no esta en reserva");
					}

				} // end for
					// validacion fechas
				total = true;
				for (Boolean b : validar) {
					if (b == false) {
						total = false;
						break;
					}
				}

				if (total) {
					Integer dias = fechaFin.getDayOfMonth() - fechaInicio.getDayOfMonth();
					rese.setValorSubTotal(vehi.getValorPorDia().multiply(new BigDecimal(dias)));
					rese.setValorICE(rese.getValorSubTotal().multiply(new BigDecimal(0.15F)));
					rese.setValorTotalAPagar(rese.getValorSubTotal().add(rese.getValorICE()));
					rese.setCliente(clie);
					rese.setEstado("Generada");
					rese.setFechaFin(fechaFin);
					rese.setFechaInicio(fechaInicio);
					rese.setVehiculo(vehi);
					rese.setNumeroReserva("R-" + (listaR.size() + 1));
					this.reservaRepository.insertar(rese);
					return rese.getNumeroReserva();
				} else {
					System.out.println("cumple con un rango valido NEGATIVO");
					System.out.println("No existe disponibilidad en ese rango de fechas");
					System.out.println("Disponible despues de la fecha: " + reseC.getFechaFin());
					return "nulo";
				}

			} else {
				System.out.println("Primera Reserva");
				Integer dias = fechaFin.getDayOfMonth() - fechaInicio.getDayOfMonth();
				rese.setValorSubTotal(vehi.getValorPorDia().multiply(new BigDecimal(dias)));
				rese.setValorICE(rese.getValorSubTotal().multiply(new BigDecimal(0.15F)));
				rese.setValorTotalAPagar(rese.getValorSubTotal().add(rese.getValorICE()));
				rese.setCliente(clie);
				rese.setEstado("Generada");
				rese.setFechaFin(fechaFin);
				rese.setFechaInicio(fechaInicio);
				rese.setVehiculo(vehi);
				rese.setNumeroReserva("R-" + (listaR.size() + 1));
				this.reservaRepository.insertar(rese);
				return rese.getNumeroReserva();
			}

		} else {
			System.out.println("tarjeta null");
			return "nulo";
		}

	}

	@Override
	public List<VehiculoDTO> buscarPorModeloMarca(String marca, String modelo) {
		// TODO Auto-generated method stub
		return this.vehiculoRepository.seleccionarPorModeloMarca(marca, modelo);
	}

	@Override
	public List<VehiculoDTO> buscarPorModeloMarcaDisponible(String marca, String modelo) {
		// TODO Auto-generated method stub
		return this.vehiculoRepository.seleccionarPorModeloMarcaDisponible(marca, modelo);
	}
}