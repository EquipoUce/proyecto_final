package com.uce.edu;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Reserva;
import com.uce.edu.service.IReservaService;

@SpringBootApplication
public class ProyectoFinalApplication implements CommandLineRunner{
	@Autowired
	private IReservaService reservaService;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(ProyectoFinalApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		List<Reserva> prueba= this.reservaService.reportarPorRangoFecha(LocalDateTime.of(2024, 3, 1, 10, 0), LocalDateTime.of(2024, 3, 5, 18, 0));
		for (Reserva reserva:prueba) {
			System.out.println(reserva);
		}
	}

}
