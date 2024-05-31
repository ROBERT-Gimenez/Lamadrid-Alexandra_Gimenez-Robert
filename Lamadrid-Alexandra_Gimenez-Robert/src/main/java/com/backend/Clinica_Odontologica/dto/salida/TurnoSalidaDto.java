package com.backend.Clinica_Odontologica.dto.salida;

import com.backend.Clinica_Odontologica.entity.Odontologo;
import com.backend.Clinica_Odontologica.entity.Paciente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TurnoSalidaDto {

    private Long id;
    private LocalDateTime fechaYHora;
    private Odontologo odontologo;
    private Paciente paciente;

    @Override
    public String toString() {
        return "TurnoSalidaDto{" +
                "id=" + id +
                ", fechaYHora=" + fechaYHora +
                ", odontologo=" + odontologo +
                ", paciente=" + paciente +
                '}';
    }
}