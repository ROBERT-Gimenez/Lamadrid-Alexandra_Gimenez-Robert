package com.backend.Clinica_Odontologica.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TURNOS")
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fechaYHora;

    @ManyToOne
    @JoinColumn(name = "odontologos_id")
    private Odontologo odontologo;
    @ManyToOne
    @JoinColumn(name = "pacientes_id")
    private Paciente paciente;

    public Turno(LocalDateTime fechaYHora, Odontologo odontologo, Paciente paciente) {

        this.fechaYHora = fechaYHora;
        this.odontologo = odontologo;
        this.paciente = paciente;
    }
}
