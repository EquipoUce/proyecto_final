package com.uce.edu.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.repository.modelo.dto.ReservaDTO;
import com.uce.edu.service.IReservaService;
import com.uce.edu.service.TO.RangoFechasTO;

@Controller
@RequestMapping("/reservas")
public class ReservasPorRangoController {
	
	@Autowired
    private IReservaService iReservaService;

    @PostMapping("/buscarReservas")
    public String buscarReservas(@ModelAttribute RangoFechasTO rangoFechasTO, Model model) {
        // Accedemos a las fechas desde el objeto 'rangoFechasTO'
        LocalDateTime fechaInicio = rangoFechasTO.getFechaInicio();
        LocalDateTime fechaFin = rangoFechasTO.getFechaFin();

        // Llamamos al método en tu servicio con las fechas
        List<ReservaDTO> reservas = iReservaService.reportarPorRangoFecha(fechaInicio, fechaFin);

        // Agregamos las reservas al modelo para mostrarlas en la vista de resultados
        model.addAttribute("reservas", reservas);

        // Retornamos la vista que mostrará las reservas encontradas
        return "vistaBuscarReserva5";
    }

}
