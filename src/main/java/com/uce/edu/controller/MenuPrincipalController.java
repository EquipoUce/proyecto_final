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
import org.springframework.web.bind.annotation.RequestParam;

import com.uce.edu.repository.modelo.Cliente;
import com.uce.edu.repository.modelo.dto.ReservaDTO;
import com.uce.edu.service.IClienteService;
import com.uce.edu.service.IReservaService;
import com.uce.edu.service.TO.RangoFechasTO;

@Controller
@RequestMapping("/menuPrincipal")
public class MenuPrincipalController {

	@Autowired
	private IClienteService clienteService;
	
	@Autowired
    private IReservaService iReservaService;
	
	// --> http://localhost:8080/menuPrincipal/inicio
	@GetMapping("/inicio")
	public String mostrarVista() {
		return "inicio1";
	}

	//--> http://localhost:8080/menuPrincipal/mostrarformularioLogin
	
	@GetMapping("/mostrarformularioLogin")
	public String mostrarformularioLogin(Model model) {
		model.addAttribute("tituloMensaje", MensajesUsuario.ADVERTENCIA.getMensaje());
		model.addAttribute("mensaje", MensajesUsuario.MENSAJE_PRINCIPAL.getMensaje());
		return "formularioLogin2";
	}
	
	//--> http://localhost:8080/menuPrincipal/mostrarMenuEmpleado
	@GetMapping("/mostrarMenuEmpleado")
	public String mostrarMenuEmpledo() {
		// Utilizamos "redirect:" para indicar la redirección
		return "menuEmpleado8";
	}

	//--> http://localhost:8080/menuClientes/mostrarFormularioBuscarVehiculo
	@GetMapping("/mostrarVistaReservasPorFechas")
	public String mostrarVistaBuscarReserva(Model model) {
		// Agregamos un objeto 'rangoFechasTO' al modelo
		RangoFechasTO rangoFechasTO = new RangoFechasTO();
		model.addAttribute("rangoFechasTO", rangoFechasTO);
		return "formularioBuscarReserva17";
	}
	
	//--> http://localhost:8080/menuClientes/buscarVehiculo
	 @PostMapping("/buscarReservas")
	    public String buscarReservas(@ModelAttribute RangoFechasTO rangoFechasTO, Model model) {
	        // Accedemos a las fechas desde el objeto 'rangoFechasTO'
	        LocalDateTime fechaInicio = rangoFechasTO.getFechaInicio();
	        System.out.println(rangoFechasTO.getFechaInicio());
	        LocalDateTime fechaFin = rangoFechasTO.getFechaFin();
	        System.out.println(rangoFechasTO.getFechaFin());
	        // Llamamos al método en tu servicio con las fechas
	        List<ReservaDTO> reservas = iReservaService.reportarPorRangoFecha(fechaInicio, fechaFin);
	        System.out.println(reservas);
	        // Agregamos las reservas al modelo para mostrarlas en la vista de resultados
	        model.addAttribute("reservas", reservas);
	        // Retornamos la vista que mostrará las reservas encontradas
	        return "vistaBuscarReserva18";
	    }

}
