package com.uce.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IVehiculoRepository;
import com.uce.edu.repository.modelo.Vehiculo;
import com.uce.edu.repository.modelo.dto.VehiculoDTO;
import com.uce.edu.service.TO.VehiculoTO;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class VehiculoServiceImpl implements IVehiculoService {
	@Autowired
	private IVehiculoRepository iVehiculoRepository;

	@Override
	public Vehiculo buscarPorPlaca(String placa) {
		// TODO Auto-generated method stub
		return this.iVehiculoRepository.seleccionarPorPlaca(placa);
	}

	@Override
	public List<VehiculoDTO> buscarPorModeloMarca(String marca, String modelo) {
		// TODO Auto-generated method stub
		return this.iVehiculoRepository.seleccionarPorModeloMarca(marca, modelo);
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void guardar(VehiculoTO vehiculo) {
		// TODO Auto-generated method stub
		Vehiculo vehi = new Vehiculo();
		vehi.setAnioFabricacion(vehiculo.getAnioFabricacion());
		vehi.setAvaluoVehiculo(vehiculo.getAvaluo());
		vehi.setCilindraje(vehiculo.getCilindraje());
		vehi.setEstado(vehiculo.getEstado());
		vehi.setMarca(vehiculo.getMarca());
		vehi.setModelo(vehiculo.getModelo());
		vehi.setPaisFabricacion(vehiculo.getPaisFabricacion());
		vehi.setPlaca(vehiculo.getPlaca());
		vehi.setValorPorDia(vehiculo.getValorDiario());
		this.iVehiculoRepository.insertar(vehi);
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void actualizar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.iVehiculoRepository.actualizar(vehiculo);
	}

}
