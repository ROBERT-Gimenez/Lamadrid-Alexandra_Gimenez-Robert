package com.backend.Clinica_Odontologica.service;


import com.backend.Clinica_Odontologica.dto.entrada.TurnoEntradaDto;
import com.backend.Clinica_Odontologica.dto.salida.TurnoSalidaDto;
import com.backend.Clinica_Odontologica.dto.modificacion.turnoModificacionEntradaDto;
import com.backend.Clinica_Odontologica.exceptions.BadRequestException;
import com.backend.Clinica_Odontologica.exceptions.ResourceNotFoundException;

import java.util.List;

public interface ITurnoService {

    TurnoSalidaDto registrarTurno(TurnoEntradaDto turnoEntradaDto)  throws BadRequestException;
    List<TurnoSalidaDto> listarTurnos();
    TurnoSalidaDto buscarTurnoPorId(Long id);
    void eliminarTurno(Long id) throws ResourceNotFoundException;

    TurnoSalidaDto modificarTurno(turnoModificacionEntradaDto TurnoModificacionEntradaDto) throws ResourceNotFoundException;
}