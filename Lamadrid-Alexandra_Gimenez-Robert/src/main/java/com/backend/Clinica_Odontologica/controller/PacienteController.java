package com.backend.Clinica_Odontologica.controller;


import com.backend.Clinica_Odontologica.dto.entrada.PacienteEntradaDto;
import com.backend.Clinica_Odontologica.dto.modificacion.PacienteModificacionEntradaDto;
import com.backend.Clinica_Odontologica.dto.salida.PacienteSalidaDto;
import com.backend.Clinica_Odontologica.exceptions.ResourceNotFoundException;
import com.backend.Clinica_Odontologica.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("pacientes")
@CrossOrigin
public class PacienteController {
    private final IPacienteService pacienteService;

    @Autowired
    public PacienteController(IPacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping()
    public ResponseEntity<List<PacienteSalidaDto>> listarPacientes() {
        return new ResponseEntity<>(pacienteService.listarPacientes(), HttpStatus.OK);
    }
    //POST
    @PostMapping("/registrar")
    public ResponseEntity<PacienteSalidaDto> registrarPaciente(@Valid @RequestBody PacienteEntradaDto paciente) {
        return new ResponseEntity<>(pacienteService.registrarPaciente(paciente), HttpStatus.CREATED);
    }

    //PUT
    @PutMapping("actualizar")
    public ResponseEntity<PacienteSalidaDto> actualizarPaciente(@Valid @RequestBody PacienteModificacionEntradaDto paciente) throws ResourceNotFoundException{
        return new ResponseEntity<>(pacienteService.modificarPaciente(paciente), HttpStatus.OK);
    }


    //GET
    @GetMapping("{id}")
    public ResponseEntity<PacienteSalidaDto> obtenerPacientePorId (@PathVariable Long id) {
        return new ResponseEntity<>(pacienteService.buscarPacientePorId(id), HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Long id) throws ResourceNotFoundException {
        pacienteService.eliminarPaciente(id);
        return new ResponseEntity<>("Paciente eliminado correctamente", HttpStatus.NO_CONTENT);
    }

}
