package com.medtriage_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medtriage_backend.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}