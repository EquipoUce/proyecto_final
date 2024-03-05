package com.uce.edu.controller;

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
import com.uce.edu.repository.modelo.dto.VehiculoDTO;
import com.uce.edu.service.IClienteService;
import com.uce.edu.service.TO.ClienteTO;
import com.uce.edu.service.TO.ReservaVehiculoTO;
import com.uce.edu.service.TO.VehiculoTO;

@Controller
@RequestMapping("/menuClientes")

public class MenuClienteController {
	
	 @Autowired
	 private IClienteService iClienteService;

	 //--> http://localhost:8080/menuClientes/mostrarMenuCliente
    @GetMapping("/mostrarMenuCliente")
	public String mostrarMenuCliente() {
		// Utilizamos "redirect:" para indicar la redirección
		return "menuCliente4";
	}
    
    @GetMapping("/mostrarErrorRegistro")
	public String mostrarErrorRegistro(Model model) {
		// Your logic to set up the model or any other necessary operations
		return "mensajeFracasoRegistro"; // Return the Thymeleaf view name
	}
    
    @PostMapping("/loginCliente")
    public String loginCliente(@RequestParam("cedula") String cedula, Model model) {
        Cliente cliente = iClienteService.buscarPorCedula(cedula);

        if (cliente != null) {
            return "redirect:/menuClientes/mostrarMenuCliente";
        } else {
            return "redirect:/menuClientes/mostrarErrorRegistro";
        }
    }
    
    @GetMapping("/mostrarFormularioRegistrarClienteDesdeError")
    public String mostrarFormularioRegistrarClienteDesdeError(Model model) {
        model.addAttribute("clienteTO", new ClienteTO());
        return "formularioRegistrarCliente3";
    }
    
    @PostMapping("/registrarCliente")
    public String registrarCliente(@ModelAttribute("clienteTO") ClienteTO clienteTO, Model model) {
        // Aquí debes llamar al servicio para registrar el cliente usando los datos en clienteTO
        iClienteService.guardar(clienteTO);
        // Después de registrar, redirige según la lógica
        return "redirect:/menuClientes/mostrarMenuCliente";
    }
    
    @GetMapping("/mostrarFormularioBuscarVehiculo")
    public String mostrarFormularioBuscarVehiculo(Model model) {
        model.addAttribute("vehiculoTO", new VehiculoTO());
        return "formularioBuscarMarcaModelo5";
    }
    
    @PostMapping("/buscarVehiculo")
    public String buscarVehiculo(@ModelAttribute("vehiculoDTO") VehiculoTO vehiculoTO, Model model) {
        String marca = vehiculoTO.getMarca();
        String modelo = vehiculoTO.getModelo();
        List<VehiculoDTO> vehiculosEncontrados = iClienteService.buscarPorModeloMarca(marca, modelo);
        model.addAttribute("vehiculos", vehiculosEncontrados);
        return "vistaBuscarMarcaModelo6";
    }
    
    @GetMapping("/mostrarFormularioReservarVehiculo")
    public String mostrarFormularioReservarVehiculo(Model model) {
        model.addAttribute("ReservaVehiculoTO", new ReservaVehiculoTO());
        return "formularioReservarVehiculo7";
    }
    
    @PostMapping("/ReservarVehiculo")
    public String ReservarVehiculo(@ModelAttribute("ReservaVehiculoTO") ReservaVehiculoTO reservaVehiculoTO, Model model) {
        String numeroReserva = iClienteService.reservarVehiculo(reservaVehiculoTO);
        if(numeroReserva!=null) {
        	model.addAttribute("mensajeExito", "La reserva se ha realizado con éxito. Número de reserva: " + numeroReserva);
        	return "mensajeTransaccionExitosa";
        }
        else {
        	return "redirect:/menuClientes/formularioReservarVehiculo7";
        }
    }
    
    


}
