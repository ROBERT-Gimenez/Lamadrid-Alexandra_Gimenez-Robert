package com.backend.Clinica_Odontologica.dto.modificacion;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;



@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class turnoModificacionEntradaDto {

    @NotNull(message = "Debe proveerse el id del turno que se desea modificar")
    private Long id;
    @NotNull(message = "El paciente no puede ser nulo")
    private Long idPaciente;
    @NotNull(message = "El odontologo no puede ser nulo")
    private Long idOdontologo;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
    @FutureOrPresent(message = "La fecha no puede ser anterior al día de hoy")
    @NotNull(message = "Debe especificarse la fecha y hora del turno")
    private LocalDateTime fechaYHora;


}
