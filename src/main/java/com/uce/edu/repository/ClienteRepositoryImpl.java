package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class ClienteRepositoryImpl implements IClienteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Cliente seleccionarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		try {
			TypedQuery<Cliente> myQuery = this.entityManager.createQuery(
					"SELECT c FROM Cliente c WHERE c.cedula =:cedula",
					Cliente.class);
			myQuery.setParameter("cedula", cedula);
			return myQuery.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cliente);
	}

}
