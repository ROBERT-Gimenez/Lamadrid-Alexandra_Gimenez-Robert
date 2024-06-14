package com.backend.Clinica_Odontologica.controller;



import com.backend.Clinica_Odontologica.dto.entrada.OdontologoEntradaDto;
import com.backend.Clinica_Odontologica.dto.modificacion.OdontologoModificacionEntradaDto;
import com.backend.Clinica_Odontologica.dto.salida.OdontologoSalidaDto;
import com.backend.Clinica_Odontologica.exceptions.ResourceNotFoundException;
import com.backend.Clinica_Odontologica.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("odontologos")
@CrossOrigin
public class  OdontologoController {

    private final IOdontologoService odontologoService;


    @Autowired
    public OdontologoController(IOdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    //POST
    @PostMapping("/registrar")
    public ResponseEntity<OdontologoSalidaDto> registrarOdontologo(@Valid @RequestBody OdontologoEntradaDto odontologo) {
        return new ResponseEntity<>(odontologoService.registrarOdontologo(odontologo), HttpStatus.CREATED);
    }

    //PUT
    @PutMapping("/actualizar")
    public ResponseEntity<OdontologoSalidaDto> actualizarOdontologo(@Valid @RequestBody OdontologoModificacionEntradaDto odontologo)throws ResourceNotFoundException {
        return new ResponseEntity<>(odontologoService.actualizarOdontologo(odontologo), HttpStatus.OK);
    }

    //GET
    @GetMapping("/{id}")
    public ResponseEntity<OdontologoSalidaDto> obtenerOdontologoPorId(@PathVariable Long id) {
        return new ResponseEntity<>(odontologoService.buscarOdontologoPorId(id), HttpStatus.OK);
    }


    @GetMapping()
    public ResponseEntity<List<OdontologoSalidaDto>> listarOdontologos() {
        return new ResponseEntity<>(odontologoService.listarOdontologos(), HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable Long id) throws ResourceNotFoundException {
        odontologoService.eliminarOdontologo(id);
        return new ResponseEntity<>("Odontologo eliminado correctamente", HttpStatus.NO_CONTENT);
    }
}

