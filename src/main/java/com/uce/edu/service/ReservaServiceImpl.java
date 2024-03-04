package com.uce.edu.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IReservaRepository;
import com.uce.edu.repository.modelo.Reserva;
import com.uce.edu.repository.modelo.dto.ReservaDTO;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class ReservaServiceImpl implements IReservaService {
	@Autowired
	private IReservaRepository iReservaRepository;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void guardar(Reserva reserva) {
		// TODO Auto-generated method stub
		this.iReservaRepository.insertar(reserva);
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void actualizar(Reserva reserva) {
		// TODO Auto-generated method stub
		this.iReservaRepository.actualizar(reserva);
	}

	@Override
	public Reserva buscarPorNumeroReserva(String numero) {
		// TODO Auto-generated method stub
		return this.iReservaRepository.seleccionarPorNumeroReserva(numero);
	}

	@Override
	public List<ReservaDTO> reportarPorRangoFecha(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		// TODO Auto-generated method stub
		return this.iReservaRepository.seleccionarPorRangoFecha(fechaInicio, fechaFin);
	}

}
