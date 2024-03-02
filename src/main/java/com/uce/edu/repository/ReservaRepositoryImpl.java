package com.uce.edu.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Reserva;
import com.uce.edu.repository.modelo.dto.ReservaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ReservaRepositoryImpl implements IReservaRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Reserva seleccionarPorNumeroReserva(String numeroReserva) {
		// TODO Auto-generated method stub
		TypedQuery<Reserva> myQuery = this.entityManager.createQuery("SELECT r FROM Reserva r WHERE r.numero = :numero", Reserva.class);
		myQuery.setParameter("numeroReserva", numeroReserva);
		return myQuery.getSingleResult();
	}

	@Override
	public List<ReservaDTO> seleccionarPorRangoFecha(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		// TODO Auto-generated method stub
		
		TypedQuery<ReservaDTO> myQuery = this.entityManager.createQuery("SELECT NEW com.uce.edu.repository.modelo.dto.ReservaDTO "
				+ "(r.cliente.cedula, r.cliente.nombre, r.cliente.apellido,"
				+ "r.vehiculo.placa, r.vehiculo.marca,"
				+ "r.valorTotalAPagar, r.numeroReserva, r.fechaInicio, r.fechaFin, r.estado"
				+ ") FROM Reserva r WHERE r.fechaInicio = :fechaInicio AND r.fechaFin= :fechaFin", ReservaDTO.class);
		myQuery.setParameter("fechaInicio", fechaInicio);
		myQuery.setParameter("fechaFin", fechaFin);
		return myQuery.getResultList();
	}

	@Override
	public void insertar(Reserva reserva) {
		// TODO Auto-generated method stub
		this.entityManager.persist(reserva);
	}

	@Override
	public void actualizar(Reserva reserva) {
		// TODO Auto-generated method stub
		this.entityManager.merge(reserva);
	}
	
}
