package com.backend.Clinica_Odontologica.dto.salida;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fechaIngreso;
    private DomicilioSalidaDto domicilio;
}