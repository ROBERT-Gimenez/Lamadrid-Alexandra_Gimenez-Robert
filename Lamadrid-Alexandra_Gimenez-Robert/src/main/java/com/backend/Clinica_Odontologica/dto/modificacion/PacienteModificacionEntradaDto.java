package com.backend.Clinica_Odontologica.dto.modificacion;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacienteModificacionEntradaDto {


    @NotNull(message = "Debe proveerse el id del paciente que se desea modificar")
    private Long id;

    @Size(min = 2, max = 50, message = "El nombre debe tener hasta 50 caracteres")
    @NotNull(message = "El nombre del paciente no puede ser nulo")
    @NotBlank(message = "Debe especificarse el nombre del paciente")
    private String nombre;



    @Size(max = 50, message = "El apellido debe tener hasta 50 caracteres")
    @NotNull(message = "El apellido del paciente no puede ser nulo")
    @NotBlank(message = "Debe especificarse el apellido del paciente")
    private String apellido;

    @NotNull(message = "Debe especificarse el dni del paciente")
    private int dni;

    @NotNull(message = "el campo fecha  no puede ser nulo")
    @FutureOrPresent(message = "la fecha no puede ser anterior al dia de hoy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate fechaIngreso;

    @NotNull
    private domicilioModificacionEntradaDto domicilio;

}
