package com.backend.Clinica_Odontologica.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {
    private int id;
    private String nombre;
    private String apellido;
    private int dni;
    private LocalDate fechaIngreso;
    private Domicilio domicilio;

    public Paciente(String nombre, String apellido, int dni, LocalDate fechaIngreso, Domicilio domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }
}