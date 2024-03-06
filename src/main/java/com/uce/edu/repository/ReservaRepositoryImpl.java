package com.uce.edu.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Reserva;
import com.uce.edu.repository.modelo.dto.ReservaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class ReservaRepositoryImpl implements IReservaRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Reserva seleccionarPorNumeroReserva(String numeroReserva) {
		// TODO Auto-generated method stub
		TypedQuery<Reserva> myQuery = this.entityManager.createQuery("SELECT r FROM Reserva r WHERE r.numero =:numero",
				Reserva.class);
		myQuery.setParameter("numero", numeroReserva);
		return myQuery.getSingleResult();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<ReservaDTO> seleccionarPorRangoFecha(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		// TODO Auto-generated method stub

		TypedQuery<ReservaDTO> myQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.repository.modelo.dto.ReservaDTO "
						+ "(r.cliente.cedula, r.cliente.nombre, r.cliente.apellido,"
						+ "r.vehiculo.placa, r.vehiculo.marca,"
						+ "r.valorTotalAPagar, r.numero, r.fechaInicio, r.fechaFin, r.estado"
						+ ") FROM Reserva r WHERE r.fechaInicio >=:fechaInicio OR r.fechaFin <=:fechaFin",
				ReservaDTO.class);
		myQuery.setParameter("fechaInicio", fechaInicio);
		myQuery.setParameter("fechaFin", fechaFin);
		return myQuery.getResultList();
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Reserva reserva) {
		// TODO Auto-generated method stub
		this.entityManager.persist(reserva);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Reserva reserva) {
		// TODO Auto-generated method stub
		this.entityManager.merge(reserva);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Reserva> seleccionarPorRango(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		// TODO Auto-generated method stub
		CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Reserva> criteriaQuery = criteriaBuilder.createQuery(Reserva.class);
		// from
		Root<Reserva> myFrom = criteriaQuery.from(Reserva.class);
		// Where
		Predicate condicionFechaInicio = criteriaBuilder.lessThanOrEqualTo(myFrom.get("fechaInicio"), fechaInicio);
		// Cree un predicado para probar si el primer argumento es menor que el segundo.
		Predicate condicionFechaFin = criteriaBuilder.greaterThan(myFrom.get("fechaFin"), fechaFin); // equal(myFrom.get("fechaFin"),
																										// fechaFin);
		Predicate condicionFinal = criteriaBuilder.and(condicionFechaInicio, condicionFechaFin);

		criteriaQuery.select(myFrom).where(condicionFinal);

		TypedQuery<Reserva> query = this.entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Reserva> seleccionarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Reserva> mq = this.entityManager.createQuery("SELECT r FROM Reserva r", Reserva.class);
		return mq.getResultList();
	}

}
