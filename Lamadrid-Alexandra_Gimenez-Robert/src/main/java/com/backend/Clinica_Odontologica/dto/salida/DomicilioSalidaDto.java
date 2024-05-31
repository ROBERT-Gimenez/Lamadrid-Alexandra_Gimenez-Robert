package com.backend.Clinica_Odontologica.dto.salida;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DomicilioSalidaDto {

    private Long id;
    private String calle;
    private Long numero;
    private String localidad;
    private String provincia;
}