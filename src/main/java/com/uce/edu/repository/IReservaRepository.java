package com.uce.edu.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.repository.modelo.Reserva;

public interface IReservaRepository {
	public Reserva seleccionarPorNumero (String numero);
	public List<Reserva> reportarPorRangoFecha (LocalDateTime fechaInicio,LocalDateTime fechaFin);
	public void insertar (Reserva reserva);
	public void actualizar (Reserva reserva);
	public void eliminarPorNumero (String numero);

}
