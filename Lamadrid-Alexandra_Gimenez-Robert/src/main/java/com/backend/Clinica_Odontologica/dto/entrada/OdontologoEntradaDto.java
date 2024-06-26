package com.backend.Clinica_Odontologica.dto.entrada;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OdontologoEntradaDto {

    @NotNull(message = "La matricula no puede ser nula")
    @NotBlank(message = "Debe especificarse la matricula del odontologo")
    @Pattern(regexp = "^[A-Z]{2}-\\d{1,3}\\d*$" , message = "Formato invalido , ej:AS-4589304")
    @Size(min = 10, message = "El campo debe tener mínimo 10 caracteres")
    private String matricula;

    @Size(max = 50, message = "El nombre debe tener hasta 50 caracteres")
    @NotNull(message = "El nombre no puede ser nulo")
    @NotBlank(message = "Debe especificarse el nombre del odontologo")
    private String nombre;

    @Size(max = 50, message = "El apellido debe tener hasta 50 caracteres")
    @NotNull(message = "El apellido no puede ser nulo")
    @NotBlank(message = "Debe especificarse el apellido del odontologo")
    private String apellido;

}