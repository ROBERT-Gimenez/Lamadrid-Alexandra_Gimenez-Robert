package com.backend.parcial.test;

import com.backend.parcial.dao.impl.OdontologoDaoH2;
import com.backend.parcial.model.Odontologo;
import com.backend.parcial.service.OdontologoService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoServiceTest {
    private final OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

    @Test
    public void listarTodosLosOdonlogos() {
            List<Odontologo> odontologoList = odontologoService.listarOdontologos();
            assertFalse(odontologoList.isEmpty());
    }
}