package com.uce.edu.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Reserva;

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
	public Reserva seleccionarPorNumero(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Reserva> myQuery = this.entityManager.createQuery("SELECT r FROM Reserva r WHERE r.numero = :numero", Reserva.class);
		myQuery.setParameter("numero", numero);
		return myQuery.getSingleResult();
	}

	// select * from reserva r where fechaI = 52/52/52 y fecha F =25/25/25
	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Reserva> reportarPorRangoFecha(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		// TODO Auto-generated method stub
		//select
		CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Reserva> criteriaQuery = criteriaBuilder.createQuery(Reserva.class);
		//from
		Root<Reserva> myFrom = criteriaQuery.from(Reserva.class);
		//Where
		Predicate condicionFechaInicio = criteriaBuilder.equal(myFrom.get("fechaInicio"), fechaInicio);
		Predicate condicionFechaFin = criteriaBuilder.equal(myFrom.get("fechaFin"), fechaFin);
		
		//Union condificionFechaIncio y condificionFechaFin
		Predicate condicionFinal = criteriaBuilder.and(condicionFechaInicio,condicionFechaFin);
		
		criteriaQuery.select(myFrom).where(condicionFinal);
		
		TypedQuery<Reserva> query = this.entityManager.createQuery(criteriaQuery);
		return query.getResultList();
		//revisar el join 
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
	@Transactional(value = TxType.MANDATORY)
	public void eliminarPorNumero(String numero) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.seleccionarPorNumero(numero));
	}

}
