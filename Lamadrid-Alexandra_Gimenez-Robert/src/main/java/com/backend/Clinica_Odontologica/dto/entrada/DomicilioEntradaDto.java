package com.backend.Clinica_Odontologica.dto.entrada;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DomicilioEntradaDto {


    @NotNull(message = "la calle no puede ser nula")
    @NotBlank(message = "debe especificarse el nombre de la calle")
    private String calle;


    @NotNull(message = "el numero no puede ser nulo")
    @Digits(integer = 8, fraction = 0, message = "el numero debe tener maximo 8 digitos")
    private int numero;

    @NotNull(message = "la localidad no puede ser nula")
    @NotBlank(message = "debe especificarse el nombre de la localidad")
    private String localidad;

    @NotNull(message = "la provincia no puede ser nula")
    @NotBlank(message = "debe especificarse el nombre de la provincia")
    private String provincia;

}
