package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IClienteRepository;
import com.uce.edu.repository.modelo.Cliente;
@Service
public class ClienteServiceImpl implements IClienteService {
	@Autowired
	private IClienteRepository clienteRepository;

	@Override
	public Cliente buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.clienteRepository.seleccionarPorCedula(cedula);
	}

	@Override
	public void guardar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.clienteRepository.insertar(cliente);
	}

}
