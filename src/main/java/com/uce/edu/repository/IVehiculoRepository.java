package com.uce.edu.repository;

import java.util.List;

import com.uce.edu.repository.modelo.Vehiculo;

public interface IVehiculoRepository {
	public Vehiculo seleccionarPorPlaca (String placa);
	public List<Vehiculo> seleccionarPorModeloMarca (String marca, String modelo);
	public void insertar (Vehiculo vehiculo);
	public void actualizar (Vehiculo vehiculo);
	public void eliminarPorPlaca (String placa);

}
