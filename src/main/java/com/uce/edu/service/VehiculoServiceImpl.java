package com.uce.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IVehiculoRepository;
import com.uce.edu.repository.modelo.Vehiculo;
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
	public List<Vehiculo> buscarPorModeloMarca(String marca, String modelo) {
		// TODO Auto-generated method stub
		return this.iVehiculoRepository.seleccionarPorModeloMarca(marca, modelo);
	}

	@Override
	public void guardar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.iVehiculoRepository.insertar(vehiculo);
	}

	@Override
	public void actualizar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.iVehiculoRepository.actualizar(vehiculo);
	}

	@Override
	public void borrarPorPlaca(String placa) {
		// TODO Auto-generated method stub
		this.iVehiculoRepository.eliminarPorPlaca(placa);
	}

}
