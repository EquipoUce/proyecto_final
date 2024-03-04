package com.uce.edu.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.repository.modelo.Reserva;
import com.uce.edu.repository.modelo.dto.ReservaDTO;

public interface IReservaService {
	public Reserva buscarPorNumeroReserva(String numero);

	public List<ReservaDTO> reportarPorRangoFecha(LocalDateTime fechaInicio, LocalDateTime fechaFin);

	public void guardar(Reserva reserva);

	public void actualizar(Reserva reserva);

}
