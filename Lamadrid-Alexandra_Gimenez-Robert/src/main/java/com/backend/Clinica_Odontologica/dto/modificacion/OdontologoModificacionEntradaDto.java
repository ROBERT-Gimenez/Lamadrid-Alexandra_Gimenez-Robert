package com.backend.Clinica_Odontologica.dto.modificacion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OdontologoModificacionEntradaDto {
    @NotNull
    private Long id;
    @NotNull
    private String matricula;
    @NotNull
    private String nombre;
    @NotNull
    private String apellido;
}



