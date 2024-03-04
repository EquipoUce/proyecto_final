package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Reserva;
import com.uce.edu.repository.modelo.dto.ReservaDTO;
import com.uce.edu.repository.modelo.dto.VehiculoDTO;
import com.uce.edu.service.IClienteService;
import com.uce.edu.service.IEmpleadoService;
import com.uce.edu.service.IReservaService;
import com.uce.edu.service.IVehiculoService;
import com.uce.edu.service.TO.ClienteTO;
import com.uce.edu.service.TO.ReservaVehiculoTO;
import com.uce.edu.service.TO.VehiculoTO;

@SpringBootApplication
public class ProyectoFinalApplication implements CommandLineRunner {
	@Autowired
	private IReservaService reservaService;

	@Autowired
	private IVehiculoService iVehiculoService;

	@Autowired
	private IClienteService clienteService;

	@Autowired
	private IEmpleadoService empleadoService;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(ProyectoFinalApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		List<ReservaDTO> prueba = this.reservaService.reportarPorRangoFecha(LocalDateTime.of(2024, 3, 1, 10, 0),
				LocalDateTime.of(2024, 3, 5, 18, 0));
		List<VehiculoDTO> pru2 = this.iVehiculoService.buscarPorModeloMarca("carro", "carroo");
		// reservarVehiculo(String placa, String cedula, LocalDateTime fechaInicio,
		// LocalDateTime fechaFin) {

		ClienteTO cliente = new ClienteTO();
		cliente.setCedula("101010");
		cliente.setNombre("Juan");
		cliente.setApellido("Perez");
		cliente.setFechaNacimiento(LocalDateTime.of(1990, 5, 15, 0, 0));
		cliente.setGenero("Masculino");
		cliente.setRegistro("Registro123");

		VehiculoTO vehiculo = new VehiculoTO();
		vehiculo.setPlaca("ABC456");
		vehiculo.setModelo("Sedan");
		vehiculo.setMarca("Toyota");
		vehiculo.setAnioFabricacion("2022");
		vehiculo.setPaisFabricacion("Japón");
		vehiculo.setCilindraje("2000cc");
		vehiculo.setAvaluo(BigDecimal.valueOf(25000.00));
		vehiculo.setValorDiario(BigDecimal.valueOf(50.00));
		vehiculo.setEstado("Disponible");

		Reserva reserva = new Reserva();
		reserva.setNumeroReserva("R123412");
		reserva.setFechaInicio(LocalDateTime.now());
		reserva.setFechaFin(LocalDateTime.now().plusDays(5));
		reserva.setEstado("Activa");
		reserva.setValorSubTotal(BigDecimal.valueOf(200.00));
		reserva.setValorICE(BigDecimal.valueOf(20.00));
		reserva.setValorTotalAPagar(BigDecimal.valueOf(220.00));

		// Asociar Cliente y Vehiculo a la Reserva
//		reserva.setCliente(clie);
		//
//		reserva.setVehiculo(vehi); // Asociar la Reserva al Cliente
//		List<Reserva> reservasCliente = new ArrayList<>();
//		reservasCliente.add(reserva);
//		clie.setReservas(reservasCliente); // Asociar la Reserva al Vehiculo
//		List<Reserva> reservasVehiculo = new ArrayList<>();
//		reservasVehiculo.add(reserva);
//		vehi.setReservas(reservasVehiculo);
//		this.clienteService.guardar(cliente);
//		this.iVehiculoService.guardar(vehiculo);

//		this.reservaService.guardar(reserva);

		ReservaVehiculoTO re = new ReservaVehiculoTO();
		re.setCedulaCliente("101010");
		re.setFechaInicio(LocalDateTime.of(2024, 3, 8, 0, 0));
		re.setFechaFin(LocalDateTime.of(2024, 3, 10, 0, 0));
		re.setNumeroTarjeta("1212");
		re.setPlaca("ABC456");
//		this.clienteService.reservarVehiculo(re);

		this.iVehiculoService.buscarPorModeloMarca("Toyota", "Sedan");
		this.iVehiculoService.buscarPorPlaca("ABC456");

		this.reservaService.reportarPorRangoFecha(LocalDateTime.of(2024, 3, 8, 0, 0),
				LocalDateTime.of(2024, 3, 10, 0, 0));
		this.empleadoService.retirarReservado("R-0");
		this.reservaService.buscarPorNumeroReserva("R-0");

	}

}
