package com.uce.edu.repository;

import java.util.List;

import com.uce.edu.repository.modelo.Vehiculo;
import com.uce.edu.repository.modelo.dto.VehiculoDTO;

public interface IVehiculoRepository {
	public Vehiculo seleccionarPorPlaca (String placa);
	public List<VehiculoDTO> seleccionarPorModeloMarca (String marca, String modelo);
	public void insertar (Vehiculo vehiculo);
	public void actualizar (Vehiculo vehiculo);

}
