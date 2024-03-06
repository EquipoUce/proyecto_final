package com.uce.edu.controller;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uce.edu.repository.modelo.Cliente;
import com.uce.edu.repository.modelo.dto.VehiculoDTO;
import com.uce.edu.service.EmpleadoService;
import com.uce.edu.service.IClienteService;
import com.uce.edu.service.TO.ClienteTO;
import com.uce.edu.service.TO.ReservaVehiculoTO;
import com.uce.edu.service.TO.VehiculoTO;

@Controller
@RequestMapping("/menuClientes")

public class MenuClienteController {

	@Autowired
	private IClienteService iClienteService;

	@Autowired
	private EmpleadoService empleadoService;

	// --> http://localhost:8080/menuClientes/mostrarMenuCliente
	@GetMapping("/mostrarMenuCliente")
	public String mostrarMenuCliente() {
		// Utilizamos "redirect:" para indicar la redirección
		return "menuCliente4";
	}

	// --> http://localhost:8080/menuClientes/mostrarErrorRegistro
	@GetMapping("/mostrarErrorRegistro")
	public String mostrarErrorRegistro(Model model) {
		// Your logic to set up the model or any other necessary operations
		return "mensajeFracasoRegistro"; // Return the Thymeleaf view name
	}

	// -->http://localhost:8080/menuPrincipal/mostrarformularioLogin

	@PostMapping("/loginCliente")
	public String loginCliente(@RequestParam("cedula") String cedula, Model model) {
		Cliente cliente = iClienteService.buscarPorCedula(cedula);
		if (cedula.isEmpty()) {
			model.addAttribute("tituloMensaje", MensajesUsuario.ERROR.getMensaje());
			model.addAttribute("mensaje", MensajesUsuario.EN_BLANCO.getMensaje());
			return "formularioLogin2";
		}
		if (cliente != null) {
			return "redirect:/menuClientes/mostrarMenuCliente";
		} else {
			return "redirect:/menuClientes/mostrarErrorRegistro";
		}
	}

	// -->http://localhost:8080/menuClientes/mostrarErrorRegistro

	@GetMapping("/mostrarFormularioRegistrarClienteDesdeError")
	public String mostrarFormularioRegistrarClienteDesdeError(Model model) {
		model.addAttribute("clienteTO", new ClienteTO());
		return "formularioRegistrarCliente3";
	}

	// -->
	// http://localhost:8080/menuClientes/mostrarFormularioRegistrarClienteDesdeError

	@PostMapping("/registrarCliente")
	public String registrarCliente(@ModelAttribute("clienteTO") ClienteTO clienteTO, Model model) {
		// Aquí debes llamar al servicio para registrar el cliente usando los datos en
		// clienteTO
		Predicate<ClienteTO> validarParametros = c -> !c.getCedula().isEmpty() && !c.getApellido().isEmpty()
				&& !c.getNombre().isEmpty() && c.getFechaNacimiento() != null && !c.getRegistro().isEmpty()
				&& !c.getGenero().isEmpty();
		List<String> listaClienteBooleana = Arrays.asList("C", "Cliente", "Clie", "Cl", "cliente", "c");
		List<String> listaEmpleadoBooleana = Arrays.asList("E", "empleado", "Empleado", "Em", "e");
		Predicate<String> perteneceAListaCliente = s -> listaClienteBooleana.contains(s);
		Predicate<String> perteneceAListaEmpleado = s -> listaEmpleadoBooleana.contains(s);
		List<String> listaGeneroFemenino = Arrays.asList("F", "f", "Fe", "fe", "Femenino", "femenino", "FEMENINO");
		List<String> listaGeneroMasculino = Arrays.asList("M", "m", "Ma", "ma", "Mascuino", "masculino", "MASCULINO");
		Consumer<String> actualizarGenero = (nuevoGenero) -> {
			if (listaGeneroFemenino.contains(nuevoGenero)) {
				clienteTO.setGenero("Femenino");
			} else if (listaGeneroMasculino.contains(nuevoGenero)) {
				clienteTO.setGenero("Masculino");
			} else {
				clienteTO.setGenero("No especificado");
			}
		};

		if (validarParametros.test(clienteTO)) {
			if (perteneceAListaCliente.test(clienteTO.getRegistro())) {
				actualizarGenero.accept(clienteTO.getGenero());
				iClienteService.guardar(clienteTO);
				return "redirect:/menuClientes/mostrarMenuCliente";

			} else if (perteneceAListaEmpleado.test(clienteTO.getRegistro())) {
				actualizarGenero.accept(clienteTO.getGenero());
				empleadoService.guardarCliente(clienteTO);
				return "redirect:/menuPrincipal/mostrarMenuEmpleado";

			} else {
				return "redirect:/menuClientes/mostrarFormularioRegistrarClienteDesdeError";
			}

		} else {
			return "redirect:/menuClientes/mostrarFormularioRegistrarClienteDesdeError";
		}

	}

	// --> http://localhost:8080/menuClientes/mostrarFormularioBuscarVehiculo
	@GetMapping("/mostrarFormularioBuscarVehiculo")
	public String mostrarFormularioBuscarVehiculo(Model model) {
		model.addAttribute("vehiculoTO", new VehiculoTO());
		model.addAttribute("tituloMensaje", MensajesUsuario.ADVERTENCIA.getMensaje());
		model.addAttribute("mensaje", MensajesUsuario.BUCLE.getMensaje());
		return "formularioBuscarMarcaModelo5";
	}

	// --> http://localhost:8080/menuClientes/buscarVehiculo
	@PostMapping("/buscarVehiculo")
	public String buscarVehiculo(@ModelAttribute("vehiculoDTO") VehiculoTO vehiculoTO, Model model) {
		String marca = vehiculoTO.getMarca();
		String modelo = vehiculoTO.getModelo();

		if (!marca.isEmpty() && !modelo.isEmpty()) {
			List<VehiculoDTO> vehiculosEncontrados = iClienteService.buscarPorModeloMarcaDisponible(marca, modelo);
			System.out.println(vehiculosEncontrados.isEmpty());
			if (!vehiculosEncontrados.isEmpty()) {
				model.addAttribute("vehiculos", vehiculosEncontrados);
				return "vistaBuscarMarcaModelo6";
			} else {
				String mensaje = "No existe un vehiculo con la Marca: " + marca + " y Modelo: " + modelo
						+ " disponible en este momento o no existe en nuestro sistema";
				model.addAttribute("mensajeFracaso", mensaje);
				return "mensajeFracasoBuscarVehiculo";
			}

		} else  {
			return "redirect:/menuClientes/mostrarFormularioBuscarVehiculo";
		}

	}

	@GetMapping("/mostrarFormularioReservarVehiculo")
	public String mostrarFormularioReservarVehiculo(Model model) {
		model.addAttribute("ReservaVehiculoTO", new ReservaVehiculoTO());
		return "formularioReservarVehiculo7";
	}

	// --> http://localhost:8080/menuClientes/vistaReservaFallida
	@GetMapping("/vistaReservaFallida")
	public String ReservarVehiculoF(Model model) {
		model.addAttribute("mensajeFallido", "La reserva NO se realizo");
		return "mensajeTransaccionFallida";
	}

	// --> http://localhost:8080/menuClientes/ReservarVehiculo
	@PostMapping("/ReservarVehiculo")
	public String ReservarVehiculo(@ModelAttribute("ReservaVehiculoTO") ReservaVehiculoTO reservaVehiculoTO,
			Model model) {
		String numeroReserva = iClienteService.reservarVehiculo(reservaVehiculoTO);
		// No existe disponibilidad en ese rango de fechas//
		if (numeroReserva != "nulo") {
			model.addAttribute("mensajeExito",
					"La reserva se ha realizado con éxito. Número de reserva: " + numeroReserva);
			return "mensajeTransaccionExitosa";
		} else {
			return "redirect:/menuClientes/vistaReservaFallida";
		}
	}


}
