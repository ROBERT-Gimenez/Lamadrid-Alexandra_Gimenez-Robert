package com.backend.Clinica_Odontologica.dto.salida;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OdontologoSalidaDto {
    private Long id;
    private int matricula;
    private String nombre;
    private String apellido;
}