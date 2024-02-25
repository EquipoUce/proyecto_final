package com.uce.edu.service;

import com.uce.edu.repository.modelo.Cliente;

public interface IClienteService {
	public Cliente buscarPorCedula (String cedula);
	public void guardar (Cliente cliente);
	public void actualizar (Cliente cliente);
	public void borrarPorCedula (String cedula);

}
