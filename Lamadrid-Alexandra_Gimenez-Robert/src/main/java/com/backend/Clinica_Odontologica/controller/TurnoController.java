package com.backend.Clinica_Odontologica.controller;


import com.backend.Clinica_Odontologica.dto.modificacion.turnoModificacionEntradaDto;
import com.backend.Clinica_Odontologica.dto.entrada.TurnoEntradaDto;
import com.backend.Clinica_Odontologica.dto.salida.TurnoSalidaDto;
import com.backend.Clinica_Odontologica.exceptions.BadRequestException;
import com.backend.Clinica_Odontologica.exceptions.ResourceNotFoundException;
import com.backend.Clinica_Odontologica.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/turnos")
@CrossOrigin
public class TurnoController {

    private ITurnoService TurnoService;

    @Autowired
    public TurnoController(ITurnoService turnoService) {
        this.TurnoService = turnoService;
    }

    //POST
    @PostMapping("/registrar")
    public ResponseEntity<TurnoSalidaDto> registrarTurno(@Valid @RequestBody TurnoEntradaDto turnoEntradaDto) throws BadRequestException {
        return new ResponseEntity<>(TurnoService.registrarTurno(turnoEntradaDto), HttpStatus.CREATED);
    }



    //PUT
    @PutMapping("actualizar")
    public ResponseEntity<TurnoSalidaDto> actualizarTurno(@Valid @RequestBody turnoModificacionEntradaDto TurnoModificacionEntradaDto) throws ResourceNotFoundException {
        return new ResponseEntity<>(TurnoService.modificarTurno(TurnoModificacionEntradaDto), HttpStatus.OK);
    }

    //GET
    @GetMapping("{id}")
    public ResponseEntity<TurnoSalidaDto> obtenerTurnoPorId(@PathVariable Long id) {
        return new ResponseEntity<>(TurnoService.buscarTurnoPorId(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<TurnoSalidaDto>> listarTurnos() {
        return new ResponseEntity<>(TurnoService.listarTurnos(), HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<?> eliminarTurno(@PathVariable Long id) throws ResourceNotFoundException {
        TurnoService.eliminarTurno(id);
        return new ResponseEntity<>("Turno eliminado correctamente", HttpStatus.OK);
    }


}