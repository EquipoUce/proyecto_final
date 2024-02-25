package com.uce.edu.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.repository.modelo.Reserva;

public interface IReservaService {
	public Reserva buscarPorNumero (String numero);
	public List<Reserva> reportarPorRangoFecha (LocalDateTime fechaInicio,LocalDateTime fechaFin);
	public void guardar (Reserva reserva);
	public void actualizar (Reserva reserva);
	public void borrarPorNumero (String numero);

}
