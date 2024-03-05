package com.uce.edu.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.repository.modelo.dto.ReservaDTO;
import com.uce.edu.service.IReservaService;
import com.uce.edu.service.TO.RangoFechasTO;

@Controller
@RequestMapping("/menuPrincipal")
public class MenuPrincipalController {

	@Autowired
	private IReservaService iReservaService;

	// --> http://localhost:8080/menuPrincipal/inicio
	@GetMapping("/inicio")
	public String mostrarVista() {
		return "inicio1";
	}

	// Funcionalidades de los botones del menu Principal

	@GetMapping("/mostrarMenuCliente")
	public String mostrarMenuCliente() {
		// Utilizamos "redirect:" para indicar la redirección
		return "menuCliente2";
	}

	@GetMapping("/mostrarMenuEmpleado")
	public String mostrarMenuEmpledo() {
		// Utilizamos "redirect:" para indicar la redirección
		return "menuEmpleado3";
	}

	@GetMapping("/mostrarVistaReservasPorFechas")
	public String mostrarVistaBuscarReserva(Model model) {
		// Agregamos un objeto 'rangoFechasTO' al modelo
		RangoFechasTO rangoFechasTO = new RangoFechasTO();
		model.addAttribute("rangoFechasTO", rangoFechasTO);
		return "formularioBuscarReserva4";
	}



}
