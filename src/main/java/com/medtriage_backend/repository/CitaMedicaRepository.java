package com.medtriage_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medtriage_backend.model.CitaMedica;

public interface CitaMedicaRepository extends JpaRepository<CitaMedica, Long> {

	List<CitaMedica> findByNivelPrioridad(String nivelPrioridad);
}
