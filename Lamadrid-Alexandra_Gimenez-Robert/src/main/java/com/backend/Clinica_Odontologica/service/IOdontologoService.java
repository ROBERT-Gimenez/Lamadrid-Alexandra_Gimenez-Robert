package com.backend.Clinica_Odontologica.service;

import com.backend.Clinica_Odontologica.dto.entrada.OdontologoEntradaDto;
import com.backend.Clinica_Odontologica.dto.modificacion.OdontologoModificacionEntradaDto;
import com.backend.Clinica_Odontologica.dto.salida.OdontologoSalidaDto;
import com.backend.Clinica_Odontologica.entity.Odontologo;
import com.backend.Clinica_Odontologica.exeptions.ResourceNotFoundException;

import java.util.List;

public interface IOdontologoService {
    List<OdontologoSalidaDto> listarOdontologos();

    OdontologoSalidaDto registrarOdontologo(OdontologoEntradaDto odontologo);

    OdontologoSalidaDto buscarOdontologoPorId(Long id);

    void eliminarOdontologo(Long id) throws ResourceNotFoundException;

    OdontologoSalidaDto actualizarOdontologo(OdontologoModificacionEntradaDto odontologoModificado);
}
