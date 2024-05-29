package com.backend.Clinica_Odontologica.test;

import com.backend.Clinica_Odontologica.dao.impl.OdontologoDaoH2;
import com.backend.Clinica_Odontologica.model.Odontologo;
import com.backend.Clinica_Odontologica.service.OdontologoService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;




public class OdontologoServiceTest {

    private final OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());



    @Test
    public void deberiaAgregarUnOdontologo() {
        Odontologo odontologo = new Odontologo("12345", "Patricia", "Damiani");

        Odontologo odontologoTest = odontologoService.guardarOdontologo(odontologo);

        assertTrue(odontologoTest.getId() != 0);

    }

    @Test
    public void listarTodosLosOdontologos() {
        List<Odontologo> odontologoList = odontologoService.listarOdontologos();
        assertFalse(odontologoList.isEmpty());

    }


}