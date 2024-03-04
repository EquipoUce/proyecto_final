package com.uce.edu.service;

import java.util.List;

import com.uce.edu.repository.modelo.Cliente;
import com.uce.edu.repository.modelo.dto.VehiculoDTO;
import com.uce.edu.service.TO.ClienteTO;
import com.uce.edu.service.TO.ReservaVehiculoTO;

public interface IClienteService {
	public Cliente buscarPorCedula(String cedula);

	public void guardar(ClienteTO cliente);

	public List<VehiculoDTO> buscarPorModeloMarca(String marca, String modelo);

	public boolean reservarVehiculo(ReservaVehiculoTO reserva);

}
