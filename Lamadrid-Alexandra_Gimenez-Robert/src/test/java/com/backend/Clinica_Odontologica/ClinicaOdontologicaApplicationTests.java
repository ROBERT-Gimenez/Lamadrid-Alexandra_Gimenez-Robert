package com.backend.Clinica_Odontologica;

import com.backend.Clinica_Odontologica.dto.salida.OdontologoSalidaDto;
import com.backend.Clinica_Odontologica.entity.Odontologo;
import com.backend.Clinica_Odontologica.service.impl.OdontologoService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest

class OdontologServiceTest {
	@Autowired
	private OdontologoService odontologService;

	@Test
	@Order(1)
	void testAdeberiaRegistrarUnOdontologoConUnId() {

		Odontologo odontologo = new Odontologo("12345", "Patricia", "Damiani");

		Odontologo odontologoSalidaDto = odontologService.guardarOdontologo(odontologo);

		assertNotNull(odontologoSalidaDto.getId());
		assertEquals("Sebastian", odontologoSalidaDto.getNombre());

	}

	@Test
	@Order(2)
	void testBdeberiaRetornarUnaListaNoVacia() {

		List<Odontologo> odontologos = odontologService.listarOdontologos();
		assertFalse(odontologos.isEmpty());

	}

	@Test
	@Order(3)
	void testCdeberiaRetornarUnOdontologoConIdIgualA1() {



		OdontologoSalidaDto odontologoSalidaDto = odontologService.buscarOdontologoPorId(1L);
		assertFalse(odontologoSalidaDto.getId()!=1);
	}



}