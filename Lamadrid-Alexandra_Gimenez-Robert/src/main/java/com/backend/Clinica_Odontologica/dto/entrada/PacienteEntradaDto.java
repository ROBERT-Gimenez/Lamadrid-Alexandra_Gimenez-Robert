package com.backend.Clinica_Odontologica.dto.entrada;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;


@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacienteEntradaDto {

    @NotNull(message = "el nombre del paciente no puede ser nulo")
    @NotBlank(message = "debe especificarse el nombre del paciente")
    @Size(max = 50,message = "el nombre debe tener hasta 50 caracteres")
    private String nombre;


    @NotNull(message = "el apellido paciente no puede ser nulo")
    @NotBlank(message = "debe especificarse el apellido del paciente")
    @Size(max = 50,message = "el apellido debe tener hasta 50 caracteres")
    private String apellido;

    @NotNull(message = "el dni no puede ser nulo")
    private int dni;


    @NotNull(message = "el campo fecha  no puede ser nulo")
    @FutureOrPresent(message = "la fecha no puede ser anterior al dia de hoy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fechaIngreso;

    @NotNull(message = "el campo domicilio del paciente  no puede ser nulo")
    @Valid
    private DomicilioEntradaDto domicilio;
}