package com.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Vehiculo;

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
public class VehiculoRepositoryImpl implements IVehiculoRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Vehiculo seleccionarPorPlaca(String placa) {
		// TODO Auto-generated method stub
		TypedQuery<Vehiculo> myQuery = this.entityManager.createQuery("SELECT v FROM Vehiculo v WHERE v.placa = :placa",Vehiculo.class);
		myQuery.setParameter("placa", placa);
		return myQuery.getSingleResult();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Vehiculo> seleccionarPorModeloMarca(String marca, String modelo) {
		// TODO Auto-generated method stub
		CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Vehiculo> criteriaQuery = criteriaBuilder.createQuery(Vehiculo.class);
		
		Root<Vehiculo> from = criteriaQuery.from(Vehiculo.class);
		
		Predicate condicionMarca = criteriaBuilder.equal(from.get("marca"), marca);
		Predicate condicionModelo = criteriaBuilder.equal(from.get("modelo"), modelo);
		
		Predicate condicionFinal = criteriaBuilder.and(condicionMarca,condicionModelo);
		
		criteriaQuery.select(from).where(condicionFinal);
		
		TypedQuery<Vehiculo> query = this.entityManager.createQuery(criteriaQuery);
		
		return query.getResultList();
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarPorPlaca(String placa) {
		// TODO Auto-generated method stub

	}

}
