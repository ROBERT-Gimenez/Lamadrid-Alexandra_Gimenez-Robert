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
public class domicilioModificacionEntradaDto {

    @NotNull
    private Long id;

    @NotNull
    private String calle;

    @NotNull
    private int numero;

    @NotNull
    private String localidad;

    @NotNull
    private String provincia;

}
