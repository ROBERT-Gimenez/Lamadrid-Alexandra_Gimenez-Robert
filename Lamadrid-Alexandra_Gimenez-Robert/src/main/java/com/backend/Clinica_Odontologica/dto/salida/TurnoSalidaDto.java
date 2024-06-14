package com.backend.Clinica_Odontologica.dto.salida;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TurnoSalidaDto {

    private Long id;
    private PacienteTurnoSalidaDto pacienteTurnoSalidaDto;
    private OdontologoTurnoSalidaDto odontologoTurnoSalidaDto;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime fechaYHora;
    
    @Override
    public String toString() {
        return "Id: " + id + " - Paciente: " + pacienteTurnoSalidaDto + " - Odontologo: " + odontologoTurnoSalidaDto + " - Fecha y hora: " + fechaYHora;
    }
}