package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IClienteRepository;
import com.uce.edu.repository.IReservaRepository;
import com.uce.edu.repository.IVehiculoRepository;
import com.uce.edu.repository.modelo.Cliente;
import com.uce.edu.repository.modelo.Reserva;
import com.uce.edu.repository.modelo.Vehiculo;
import com.uce.edu.repository.modelo.dto.ReservaEmpleadoDTO;
import com.uce.edu.service.TO.ClienteTO;
import com.uce.edu.service.TO.ReservaEmpleadoTO;
import com.uce.edu.service.TO.VehiculoTO;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class EmpleadoService implements IEmpleadoService {

	@Autowired
	private IClienteRepository clienteRepository;

	@Autowired
	private IVehiculoRepository vehiculoRepository;

	@Autowired
	private IReservaRepository reservaRepository;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void guardarCliente(ClienteTO cliente) {
		// TODO Auto-generated method stub
		Cliente clie = new Cliente();
		clie.setApellido(cliente.getApellido());
		clie.setCedula(cliente.getCedula());
		clie.setFechaNacimiento(cliente.getFechaNacimiento());
		clie.setGenero(cliente.getGenero());
		clie.setNombre(cliente.getNombre());
		clie.setRegistro("Empleado");
		this.clienteRepository.insertar(clie);
	}

	@Override
	public Cliente buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.clienteRepository.seleccionarPorCedula(cedula);
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void guardarVehiculo(VehiculoTO vehiculo) {
		// TODO Auto-generated method stub
		Vehiculo vehi = new Vehiculo();
		vehi.setAnioFabricacion(vehiculo.getAnioFabricacion());
		vehi.setAvaluoVehiculo(vehiculo.getAvaluo());
		vehi.setCilindraje(vehiculo.getCilindraje());
		vehi.setMarca(vehiculo.getMarca());
		vehi.setModelo(vehiculo.getModelo());
		vehi.setPaisFabricacion(vehiculo.getPaisFabricacion());
		vehi.setPlaca(vehiculo.getPlaca());
		vehi.setValorPorDia(vehiculo.getValorDiario());
		vehi.setEstado("Disponible");
		this.vehiculoRepository.insertar(vehi);

	}

	@Override
	public Vehiculo buscarPorPlaca(String placa) {
		// TODO Auto-generated method stub
		return this.vehiculoRepository.seleccionarPorPlaca(placa);
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public ReservaEmpleadoDTO generarRservaEmpleadoDTO(String numeroReserva) {
		// TODO Auto-generated method stub
		Reserva res = this.reservaRepository.seleccionarPorNumeroReserva(numeroReserva);

		if (res != null) {
			String fechaCadena = " ";
			fechaCadena.concat(res.getFechaInicio().toString()).concat("-").concat(res.getFechaFin().toString());
			ReservaEmpleadoDTO reseDTO = new ReservaEmpleadoDTO();
			reseDTO.setPlaca(res.getVehiculo().getPlaca());
			reseDTO.setCedula(res.getCliente().getCedula());
			reseDTO.setEstado(res.getEstado());
			reseDTO.setFecha(fechaCadena);
			reseDTO.setModelo(res.getVehiculo().getModelo());
			reseDTO.setNumeroReserva(numeroReserva);
			reseDTO.setEstadoVehiculo(res.getVehiculo().getEstado());
			return reseDTO;
		} else {
			return null;
		}
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void ejecutarReserva(ReservaEmpleadoDTO reservaEmpleadoDTO) {
		// TODO Auto-generated method stub
		Reserva res = this.reservaRepository.seleccionarPorNumeroReserva(reservaEmpleadoDTO.getNumeroReserva());
		Vehiculo vehi = this.vehiculoRepository.seleccionarPorPlaca(reservaEmpleadoDTO.getPlaca());
		res.setEstado("Ejecutada");
		vehi.setEstado("Indisponible");
		this.vehiculoRepository.actualizar(vehi);
		this.reservaRepository.actualizar(res);
	}
	
	

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public ReservaEmpleadoTO generarRservaEmpleadoTO(String numeroReserva) {
		// TODO Auto-generated method stub
		Reserva res = this.reservaRepository.seleccionarPorNumeroReserva(numeroReserva);

		if (res != null) {
			String fechaCadena = "";
			fechaCadena = fechaCadena+res.getFechaInicio().toString()+"-"+res.getFechaFin().toString();
			ReservaEmpleadoTO reseDTO = new ReservaEmpleadoTO();
			reseDTO.setPlaca(res.getVehiculo().getPlaca());
			reseDTO.setModelo(res.getVehiculo().getModelo());
			reseDTO.setEstado(res.getEstado());
			reseDTO.setFecha(fechaCadena);
			reseDTO.setCedula(res.getCliente().getCedula());
			reseDTO.setNumeroReserva(numeroReserva);
		
			return reseDTO;
		} else {
			return null;
		}
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void ejecutarReserva(ReservaEmpleadoTO reservaEmpleadoTO) {
		// TODO Auto-generated method stub
		Reserva res = this.reservaRepository.seleccionarPorNumeroReserva(reservaEmpleadoTO.getNumeroReserva());
		Vehiculo vehi = this.vehiculoRepository.seleccionarPorPlaca(reservaEmpleadoTO.getPlaca());
		res.setEstado("Ejecutada");
		vehi.setEstado("Indisponible");
		this.vehiculoRepository.actualizar(vehi);
		this.reservaRepository.actualizar(res);
	}
}
