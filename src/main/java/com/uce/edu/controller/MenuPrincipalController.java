package com.uce.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uce.edu.repository.modelo.Cliente;
import com.uce.edu.service.IClienteService;
import com.uce.edu.service.TO.RangoFechasTO;

@Controller
@RequestMapping("/menuPrincipal")
public class MenuPrincipalController {

	@Autowired
	private IClienteService clienteService;

	// --> http://localhost:8080/menuPrincipal/inicio
	@GetMapping("/inicio")
	public String mostrarVista() {
		return "inicio1";
	}

	// Funcionalidades de los botones del menu Principal


	@GetMapping("/mostrarformularioLogin")
	public String mostrarformularioLogin() {
		return "formularioLogin2";
	}
	
	// http://localhost:8080/menuPrincipal/mostrarMenuEmpleado?
	@GetMapping("/mostrarMenuEmpleado")
	public String mostrarMenuEmpledo() {
		// Utilizamos "redirect:" para indicar la redirección
		return "menuEmpleado8";
	}

	@GetMapping("/mostrarVistaReservasPorFechas")
	public String mostrarVistaBuscarReserva(Model model) {
		// Agregamos un objeto 'rangoFechasTO' al modelo
		RangoFechasTO rangoFechasTO = new RangoFechasTO();
		model.addAttribute("rangoFechasTO", rangoFechasTO);
		return "formularioBuscarReserva17";
	}

}
