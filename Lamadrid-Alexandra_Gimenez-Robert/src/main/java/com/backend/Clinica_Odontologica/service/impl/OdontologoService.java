package com.backend.Clinica_Odontologica.service.impl;


import com.backend.Clinica_Odontologica.dto.entrada.OdontologoEntradaDto;
import com.backend.Clinica_Odontologica.dto.modificacion.OdontologoModificacionEntradaDto;
import com.backend.Clinica_Odontologica.dto.salida.OdontologoSalidaDto;
import com.backend.Clinica_Odontologica.entity.Odontologo;
import com.backend.Clinica_Odontologica.repository.OdontologoRepository;
import com.backend.Clinica_Odontologica.service.IOdontologoService;
import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import org.slf4j.Logger;

@Service
public class OdontologoService implements IOdontologoService {

    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(OdontologoService.class);
    private final OdontologoRepository odontologoRepository;
    private final ModelMapper modelMapper;

    public OdontologoService(OdontologoRepository odontologoRepository, ModelMapper modelMapper) {
        this.odontologoRepository = odontologoRepository;
        this.modelMapper = modelMapper;
    }

    public OdontologoSalidaDto registrarOdontologo(OdontologoEntradaDto odontologo) {
        Odontologo odontologoGuardado = odontologoRepository.save(dtoEntradaAEntidad(odontologo));
        OdontologoSalidaDto odontologoSalidaDto = modelMapper.map(odontologoGuardado, OdontologoSalidaDto.class);
        LOGGER.info("Odontologo guardado: " , odontologoSalidaDto);
        return odontologoSalidaDto;
    }

    public OdontologoSalidaDto buscarOdontologoPorId(Long id) {
        Odontologo odontologoBuscado = odontologoRepository.findById(id).orElse(null);
        OdontologoSalidaDto odontologoSalidaDto = null;
        if (odontologoBuscado != null) {
            odontologoSalidaDto = modelMapper.map(odontologoBuscado, OdontologoSalidaDto.class);
            LOGGER.info("Odontologo encontrado: ", odontologoSalidaDto);
        }else {
            LOGGER.error("El id no se encuentra registrado en la base de datos");
        }
        return odontologoSalidaDto;
    }

    public List<OdontologoSalidaDto> ListarOdontologos() {
        List<OdontologoSalidaDto> odontologos = odontologoRepository.findAll().stream()
                .map(od -> modelMapper.map(od, OdontologoSalidaDto.class)).toList();
        LOGGER.info("Listado de todos los odontologos: ", odontologos);
        return odontologos;
    }

    public void eliminarOdontologo(Long id) {
        if(buscarOdontologoporId(id) != null) {
            odontologoRepository.deleteById(id);
            LOGGER.warn("Se ha eliminado el odonologo con ID: ", id);
        }else{
            LOGGER.error("No se ha encontrado el odontologo con id: " , id);
            //Retornar ExceptionNotFound
        }
    }

    @Override
    public OdontologoSalidaDto actualizarOdontologo (OdontologoModificacionEntradaDto odontologoModificado) {
        Odontologo odontologoRecibido = modelMapper.map(odontologoModificado, Odontologo.class);
        Odontologo odontologoAActualizar = odontologoRepository.findById(odontologoRecibido.getId()).orElse(null);
        OdontologoSalidaDto odontologoSalidaDto = null;
        if (odontologoAActualizar != null) {
            odontologoAActualizar = odontologoRecibido;
            odontologoRepository.save(odontologoAActualizar);
            odontologoSalidaDto = modelMapper.map(odontologoAActualizar, OdontologoSalidaDto.class);
            LOGGER.warn("Odontologo actualizado", odontologoSalidaDto);
        }else{
            LOGGER.error("No fue posible actualizar los datos ya que el odontologo no se encuentra registrado");
        }
        return odontologoSalidaDto;
    }

    private Odontologo dtoEntradaAEntidad(OdontologoEntradaDto odontologoEntradaDto) {
        return ModelMapper.map(odontologoEntradaDto, Odontologo.class);
    }
}
