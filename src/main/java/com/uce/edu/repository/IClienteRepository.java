package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Cliente;

public interface IClienteRepository {
	public Cliente seleccionarPorCedula (String cedula);
	public void insertar (Cliente cliente);

}
