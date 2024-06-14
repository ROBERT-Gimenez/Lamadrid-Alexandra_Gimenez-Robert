package com.backend.Clinica_Odontologica;

import com.backend.Clinica_Odontologica.dto.entrada.OdontologoEntradaDto;
import com.backend.Clinica_Odontologica.dto.salida.OdontologoSalidaDto;
import com.backend.Clinica_Odontologica.entity.Odontologo;
import com.backend.Clinica_Odontologica.exceptions.ResourceNotFoundException;
import com.backend.Clinica_Odontologica.service.impl.OdontologoService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:applicationTest.properties")
class OdontologoServiceTest {

	@Autowired
	private OdontologoService odontologoService;


	@Test
	@Order(1)
	void deberiaInsertarUnOdontologoDeNombreCamilaConId1(){
		OdontologoEntradaDto odontologoEntradaDto = new OdontologoEntradaDto("AS-4589304", "Roberto","lamas") ;
		OdontologoSalidaDto odontologoSalidaDto = odontologoService.registrarOdontologo(odontologoEntradaDto);

		assertEquals("Roberto", odontologoSalidaDto.getNombre());
		assertEquals(1, odontologoSalidaDto.getId());
	}


	@Order(2)
	@Test
	void deberiaRetornarseUnaListaNoVaciaDeOdontologos(){
		assertTrue(odontologoService.listarOdontologos().size() > 0);
	}


	@Test
	@Order(3)
	void alIntentarEliminarUnOdontologoYaEliminado_deberiaLanzarseUnResourceNotFoundException(){
		try{
			odontologoService.eliminarOdontologo(1L);
		} catch (Exception e){
			e.printStackTrace();
		}
		assertThrows(ResourceNotFoundException.class, () -> odontologoService.eliminarOdontologo(1L));
	}
}