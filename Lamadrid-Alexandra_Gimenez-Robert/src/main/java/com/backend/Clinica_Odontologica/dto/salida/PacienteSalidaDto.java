package com.backend.Clinica_Odontologica.dto.salida;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacienteSalidaDto {

    private Long id;
    private String nombre;
    private String apellido;
    private int dni;
    private LocalDate fechaIngreso;
    private DomicilioSalidaDto domicilioSalidaDto;
}