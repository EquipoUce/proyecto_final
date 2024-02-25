package com.uce.edu.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IReservaRepository;
import com.uce.edu.repository.modelo.Reserva;
@Service
public class ReservaServiceImpl implements IReservaService {
	@Autowired
	private IReservaRepository iReservaRepository;

	@Override
	public Reserva buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.iReservaRepository.seleccionarPorNumero(numero);
	}

	@Override
	public List<Reserva> reportarPorRangoFecha(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		// TODO Auto-generated method stub
		return this.iReservaRepository.reportarPorRangoFecha(fechaInicio, fechaFin);
	}

	@Override
	public void guardar(Reserva reserva) {
		// TODO Auto-generated method stub
		this.iReservaRepository.insertar(reserva);
	}

	@Override
	public void actualizar(Reserva reserva) {
		// TODO Auto-generated method stub
		this.iReservaRepository.actualizar(reserva);
	}

	@Override
	public void borrarPorNumero(String numero) {
		// TODO Auto-generated method stub
		this.iReservaRepository.eliminarPorNumero(numero);
	}

}
