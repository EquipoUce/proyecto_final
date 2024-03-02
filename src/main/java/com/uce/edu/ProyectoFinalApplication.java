package com.uce.edu;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.dto.ReservaDTO;
import com.uce.edu.repository.modelo.dto.VehiculoDTO;
import com.uce.edu.service.IReservaService;
import com.uce.edu.service.IVehiculoService;

@SpringBootApplication
public class ProyectoFinalApplication implements CommandLineRunner{
	@Autowired
	private IReservaService reservaService;
	
	@Autowired
	private IVehiculoService iVehiculoService;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(ProyectoFinalApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		List<ReservaDTO> prueba= this.reservaService.reportarPorRangoFecha(LocalDateTime.of(2024, 3, 1, 10, 0), LocalDateTime.of(2024, 3, 5, 18, 0));
		List<VehiculoDTO> pru2= this.iVehiculoService.buscarPorModeloMarca("carro", "carroo");
	}

}
