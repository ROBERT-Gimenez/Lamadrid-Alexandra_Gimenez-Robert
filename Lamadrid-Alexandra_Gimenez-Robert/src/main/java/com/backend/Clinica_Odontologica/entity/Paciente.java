package com.backend.Clinica_Odontologica.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PACIENTES")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 50)
    private String nombre;
    @Column(length = 50)
    private String apellido;
    @Column(length = 50)
    private int dni;
    private LocalDate fechaIngreso;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "domicilio_id")
    private Domicilio domicilio;

    public Paciente(String nombre, String apellido, int dni, LocalDate fechaIngreso, Domicilio domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }
}