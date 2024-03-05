package com.uce.edu.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
		List<Reserva> lista = this.reservaRepository.seleccionarPorRango(fechaInicio, fechaFin);
		List<Reserva> listaR = this.reservaRepository.seleccionarTodos();

		try {

			if (reservaV.getNumeroTarjeta() != " ") {

				for (Reserva r : lista) {
					if (r.getVehiculo().getPlaca().equals(placa)) {
						reseC = this.reservaRepository.seleccionarPorNumeroReserva(r.getNumeroReserva());
					}
				}
				if (reseC.getFechaFin() != null && reseC.getFechaInicio() != null) {
					// auto en la lista

					if ((fechaInicio.isAfter(reseC.getFechaFin()) && fechaFin.isAfter(reseC.getFechaFin()))
							|| (fechaInicio.isBefore(reseC.getFechaInicio())
									&& fechaFin.isBefore(reseC.getFechaInicio()))) {
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
						// indisponible en esas fechas
						System.out.println("No existe disponibilidad en ese rango de fechas");
						System.out.println("Disponible desdues de la fecha: " + reseC.getFechaFin());
						System.out.println("Disponible antes de la fecha: " + reseC.getFechaInicio());
						return null;

					}
				} else {
					// auto no en la lista

					Integer dias = fechaFin.getDayOfMonth() - fechaInicio.getDayOfMonth();
					rese.setValorSubTotal(vehi.getValorPorDia().multiply(new BigDecimal(dias)));
					rese.setValorICE(rese.getValorSubTotal().multiply(new BigDecimal(0.15F)));
					rese.setValorTotalAPagar(rese.getValorSubTotal().add(rese.getValorICE()));
					rese.setCliente(clie);
					rese.setEstado("Generada");
					rese.setFechaFin(fechaFin);
					rese.setFechaInicio(fechaInicio);
					rese.setVehiculo(vehi);
					rese.setNumeroReserva("R-" + listaR.size());
					this.reservaRepository.insertar(rese);
					return rese.getNumeroReserva();

				}
			} else {
				System.out.println("Error tarjeta NULL");
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
			return null;
		}
	}

	@Override
	public List<VehiculoDTO> buscarPorModeloMarca(String marca, String modelo) {
		// TODO Auto-generated method stub
		return this.vehiculoRepository.seleccionarPorModeloMarca(marca, modelo);
	}

}