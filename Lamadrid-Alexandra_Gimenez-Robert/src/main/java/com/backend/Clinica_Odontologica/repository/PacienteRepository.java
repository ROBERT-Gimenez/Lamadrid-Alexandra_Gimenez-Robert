package com.backend.Clinica_Odontologica.repository;

import com.backend.Clinica_Odontologica.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository <Paciente, Long> {


}