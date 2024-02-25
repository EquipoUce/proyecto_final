package com.uce.edu.service;

import java.util.List;

import com.uce.edu.repository.modelo.Vehiculo;

public interface IVehiculoService {
	public Vehiculo buscarPorPlaca (String placa);
	public List<Vehiculo> buscarPorModeloMarca (String marca, String modelo);
	public void guardar (Vehiculo vehiculo);
	public void actualizar (Vehiculo vehiculo);
	public void borrarPorPlaca (String placa);

}
