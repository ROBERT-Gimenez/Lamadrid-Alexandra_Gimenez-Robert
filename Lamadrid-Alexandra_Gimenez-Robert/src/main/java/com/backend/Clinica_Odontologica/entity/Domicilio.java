package com.backend.Clinica_Odontologica.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DOMICILIOS")
public class Domicilio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50)
    private String calle;

    @Column(length = 8)
    private Long numero;

    @Column(length = 50)
    private String localidad;

    @Column(length = 50)
    private String provincia;



    public Domicilio(String calle, Long numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }
}
