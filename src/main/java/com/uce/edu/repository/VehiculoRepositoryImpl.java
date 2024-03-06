package com.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Vehiculo;
import com.uce.edu.repository.modelo.dto.VehiculoDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
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
		try {
			TypedQuery<Vehiculo> myQuery = this.entityManager
					.createQuery("SELECT v FROM Vehiculo v WHERE v.placa = :placa", Vehiculo.class);
			myQuery.setParameter("placa", placa);
			return myQuery.getResultList().get(0);
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<VehiculoDTO> seleccionarPorModeloMarca(String marca, String modelo) {
		// TODO Auto-generated method stub

		TypedQuery<VehiculoDTO> query = this.entityManager
				.createQuery("SELECT NEW com.uce.edu.repository.modelo.dto.VehiculoDTO("
						+ "v.placa, v.modelo, v.marca, v.anioFabricacion, v.estado, v.valorPorDia) FROM Vehiculo v "
						+ "WHERE v.marca= :marca AND v.modelo= :modelo", VehiculoDTO.class);
		query.setParameter("marca", marca);
		query.setParameter("modelo", modelo);
		return query.getResultList();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<VehiculoDTO> seleccionarPorModeloMarcaDisponible(String marca, String modelo) {
		// TODO Auto-generated method stub
		try {
			TypedQuery<VehiculoDTO> query = this.entityManager.createQuery(
					"SELECT NEW com.uce.edu.repository.modelo.dto.VehiculoDTO("
							+ "v.placa, v.modelo, v.marca, v.anioFabricacion, v.estado, v.valorPorDia) FROM Vehiculo v "
							+ "WHERE v.marca= :marca AND v.modelo= :modelo AND v.estado = 'Disponible'",
					VehiculoDTO.class);
			query.setParameter("marca", marca);
			query.setParameter("modelo", modelo);
			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.entityManager.persist(vehiculo);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.entityManager.merge(vehiculo);
	}

}
