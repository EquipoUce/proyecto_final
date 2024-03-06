package com.uce.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uce.edu.repository.modelo.Cliente;
import com.uce.edu.repository.modelo.Vehiculo;
import com.uce.edu.repository.modelo.dto.ReservaEmpleadoDTO;
import com.uce.edu.service.EmpleadoService;
import com.uce.edu.service.IClienteService;
import com.uce.edu.service.IVehiculoService;
import com.uce.edu.service.TO.ClienteTO;
import com.uce.edu.service.TO.ReservaEmpleadoTO;
import com.uce.edu.service.TO.VehiculoTO;

@Controller
@RequestMapping("/menuEmpleados")
public class MenuEmpleadoController {

	@Autowired
	private IClienteService iClienteService;
	@Autowired
	private IVehiculoService iVehiculoService;

	@Autowired
	private EmpleadoService empleadoService;

	@GetMapping("/mostrarFormularioRegistrarCliente")
	public String mostrarFormularioRegistrarClienteDesdeError(Model model) {
		model.addAttribute("clienteTO", new ClienteTO());
		return "formularioRegistrarCliente3";
	}

	@GetMapping("/mostrarFormularioBuscarCliente")
	public String mostrarFormularioBuscarCliente(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "formularioBuscarCliente9";
	}

	@PostMapping("/BuscarClientePorCedula")
	public String BuscarClientePorCedula(@RequestParam("cedula") String cedula, Model model) {
		Cliente cliente = iClienteService.buscarPorCedula(cedula);
		if (cliente != null) {
			model.addAttribute("cliente", cliente);
			return "vistaBuscarCliente10";
		} else {
			return "redirect:/menuPrincipal/mostrarMenuEmpleado";
		}
	}

	@GetMapping("/mostrarFormularioRegistrarVehiculo")
	public String mostrarFormularioRegistrarVehiculo(Model model) {
		model.addAttribute("vehiculoTO", new VehiculoTO());
		return "formularioRegistrarVehuculo11";
	}

	@PostMapping("/insertarVehiculo")
	public String insertarVehiculo(@ModelAttribute("vehiculoTO") VehiculoTO vehiculoTO, Model model) {
		this.empleadoService.guardarVehiculo(vehiculoTO);
		return "redirect:/menuPrincipal/mostrarMenuEmpleado";
	}

	@GetMapping("/mostrarFormularioBuscarVehiculoEmpleado")
	public String mostrarFormularioBuscarVehiculo(Model model) {
		model.addAttribute("vehiculo", new Vehiculo());
		return "formularioBuscarVehiculoPlaca12";
	}

	@PostMapping("/BuscarVehiculoPorPlaca")
	public String BuscarVehiculoPorPlaca(@RequestParam("placa") String placa, Model model) {
		Vehiculo vehiculo = iVehiculoService.buscarPorPlaca(placa);
		if (vehiculo != null) {
			model.addAttribute("vehiculo", vehiculo);
			return "vistaBuscarVehiculo13";
		} else {
			return "redirect:/menuPrincipal/mostrarMenuEmpleado";
		}
	}

	// --> http://localhost:8080/menuEmpleados/mostrarFormularioBuscarNumeroReserva

	@GetMapping("/mostrarFormularioBuscarNumeroReserva")
	public String mostrarFormularioBuscarNumeroReserva(Model model) {
		model.addAttribute("reservaEmpleadoTO", new ReservaEmpleadoTO());
		return "formularioNumeroReserva14";
	}

	@PostMapping("/buscarReservaPorNumero")
	public String buscarReservaPorNumero(@RequestParam("numeroReserva") String numeroReserva, Model model) {
		ReservaEmpleadoTO reservaEmpleadoTO = this.empleadoService.generarRservaEmpleadoTO(numeroReserva);
		if (reservaEmpleadoTO != null) {
			model.addAttribute("reservaEmpleadoTO", reservaEmpleadoTO);
			return "vistaBuscaReservaNumero15";
		} else {
			return "redirect:/menuPrincipal/mostrarMenuEmpleado";
		}
	}

	@PutMapping("/actualizarEstadoReserva/{numeroReserva}")
	public String actualizarEstadoReserva(@PathVariable("numeroReserva") String numeroReserva,
			ReservaEmpleadoTO reservaEmpleadoTO, Model model) {

		reservaEmpleadoTO = this.empleadoService.generarRservaEmpleadoTO(numeroReserva);
		this.empleadoService.ejecutarReserva(reservaEmpleadoTO);

		String mensajeExito = "La reserva: " + reservaEmpleadoTO.getNumeroReserva() + " se actualizo con éxito";
		model.addAttribute("mensajeExito", mensajeExito);

		return "mensajeTransaccionExitosa";
	}

	@GetMapping("/mostrarRetirarSinReserva")
	public String mostrarRetirarSinReserva() {
		// Utilizamos "redirect:" para indicar la redirección
		return "menuSinReserva16";
	}

}
