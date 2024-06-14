package com.backend.Clinica_Odontologica.service;

import com.backend.Clinica_Odontologica.dto.modificacion.PacienteModificacionEntradaDto;
import com.backend.Clinica_Odontologica.dto.entrada.PacienteEntradaDto;
import com.backend.Clinica_Odontologica.dto.salida.PacienteSalidaDto;
import com.backend.Clinica_Odontologica.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IPacienteService {
    List<PacienteSalidaDto> listarPacientes();

    PacienteSalidaDto registrarPaciente(PacienteEntradaDto paciente);

    PacienteSalidaDto buscarPacientePorId(Long id);

    void eliminarPaciente(Long id) throws ResourceNotFoundException;

    PacienteSalidaDto modificarPaciente(PacienteModificacionEntradaDto pacienteModificado) throws ResourceNotFoundException;



}