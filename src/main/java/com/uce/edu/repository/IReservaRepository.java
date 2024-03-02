package com.uce.edu.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.repository.modelo.Reserva;
import com.uce.edu.repository.modelo.dto.ReservaDTO;

public interface IReservaRepository {
	public Reserva seleccionarPorNumeroReserva (String numeroReserva);
	public List<ReservaDTO> seleccionarPorRangoFecha (LocalDateTime fechaInicio,LocalDateTime fechaFin);
	public void insertar (Reserva reserva);
	public void actualizar (Reserva reserva);

}
