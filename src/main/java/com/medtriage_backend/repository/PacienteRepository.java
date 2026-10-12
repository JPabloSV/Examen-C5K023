package com.medtriage_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medtriage_backend.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}