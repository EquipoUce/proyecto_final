package com.uce.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menus")
public class Menu {
	// --> http://localhost:8080/inicio
	@GetMapping("/inicio") 
    public String mostrarVista() {
        return "inicio"; 
    }
	
	//Funcionalidades de los botones
	
	@GetMapping("/mostrarMenuCliente")
    public String mostrarMenuCliente() {
        return "redirect:/menuCliente"; // Coloca el nombre de tu archivo HTML sin la extensión
    }
}
