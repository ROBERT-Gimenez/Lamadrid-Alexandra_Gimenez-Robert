package com.backend.Clinica_Odontologica;

import com.backend.Clinica_Odontologica.dto.entrada.OdontologoEntradaDto;
import com.backend.Clinica_Odontologica.dto.entrada.DomicilioEntradaDto;
import com.backend.Clinica_Odontologica.dto.entrada.PacienteEntradaDto;
import com.backend.Clinica_Odontologica.dto.entrada.TurnoEntradaDto;
import com.backend.Clinica_Odontologica.dto.salida.TurnoSalidaDto;
import com.backend.Clinica_Odontologica.dto.salida.OdontologoSalidaDto;
import com.backend.Clinica_Odontologica.dto.salida.PacienteSalidaDto;
import com.backend.Clinica_Odontologica.exceptions.BadRequestException;
import com.backend.Clinica_Odontologica.service.impl.OdontologoService;
import com.backend.Clinica_Odontologica.service.impl.PacienteService;
import com.backend.Clinica_Odontologica.service.impl.TurnoService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestPropertySource(locations =  "classpath:applicationTest.properties")
class TurnoServiceTest {

    @Autowired
    private TurnoService turnoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;

    private static PacienteEntradaDto paciente;
    private static OdontologoEntradaDto odontologo;


    @BeforeAll
    public static void init() {
        paciente = new PacienteEntradaDto("Roberto", "lamas", 65436546, LocalDate.of(2024, 7, 15), new DomicilioEntradaDto("Calle", 1, "Localidad", "Provincia"));
        odontologo = new OdontologoEntradaDto("RR-420372", "Alexandra", "patiño");
    }

    @Test
    @Order(1)
    void deberiaRegistrarseUnTurnoAsignadoAOdontologoYPacienteExistentes() throws BadRequestException {
        PacienteSalidaDto pacienteResponseDto = pacienteService.registrarPaciente(paciente);
        OdontologoSalidaDto odontologoResponseDto = odontologoService.registrarOdontologo(odontologo);

        TurnoSalidaDto turnoResponseDto = turnoService.registrarTurno(new TurnoEntradaDto(pacienteResponseDto.getId(), odontologoResponseDto.getId(), LocalDateTime.of(LocalDate.of(2023, 10, 01), LocalTime.of(12, 30))));
        Assertions.assertNotNull(turnoResponseDto);
        Assertions.assertNotNull(turnoResponseDto.getId());
        Assertions.assertEquals("Roberto", turnoResponseDto.getPacienteTurnoSalidaDto().getNombre());
    }




    @Test
    @Order(2)
    void deberiaEncontrarTurnoId1() {
        TurnoSalidaDto turnoResponseDto = turnoService.buscarTurnoPorId(1L);
        Assertions.assertNotNull(turnoResponseDto);
        Assertions.assertNotNull(turnoResponseDto.getFechaYHora());

    }

}