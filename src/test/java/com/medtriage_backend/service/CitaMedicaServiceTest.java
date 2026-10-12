package com.medtriage_backend.service;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.medtriage_backend.dto.CitaMedicaDTO;
import com.medtriage_backend.dto.CrearCitaDTO;
import com.medtriage_backend.model.CitaMedica;
import com.medtriage_backend.model.Doctor;
import com.medtriage_backend.model.Paciente;
import com.medtriage_backend.repository.CitaMedicaRepository;
import com.medtriage_backend.repository.DoctorRepository;
import com.medtriage_backend.repository.PacienteRepository;

@ExtendWith(MockitoExtension.class)
class CitaMedicaServiceTest {

    @Mock
    private CitaMedicaRepository citaMedicaRepository;

    @Mock
    private DoctorRepository doctorRepository;

    @Mock
    private PacienteRepository pacienteRepository;

    @InjectMocks
    private CitaMedicaService citaMedicaService;

    @Test
    void crearCitaDebeDejarEstadoPendiente() {
        Doctor doctor = new Doctor();
        doctor.setId(1L);
        doctor.setNombre("Dr. Carlos Alvarado");

        Paciente paciente = new Paciente();
        paciente.setId(1L);
        paciente.setNombreCompleto("Elena Madrigal Castro");

        CrearCitaDTO datos = new CrearCitaDTO();
        datos.setCodigoCita("CIT-TEST-001");
        datos.setDoctorId(1L);
        datos.setPacienteId(1L);

        when(doctorRepository.findById(1L)).thenReturn(Optional.of(doctor));
        when(pacienteRepository.findById(1L)).thenReturn(Optional.of(paciente));
        when(citaMedicaRepository.save(any(CitaMedica.class))).thenAnswer(invocation -> {
            CitaMedica cita = invocation.getArgument(0);
            cita.setId(1L);
            return cita;
        });

        CitaMedicaDTO resultado = citaMedicaService.crear(datos);

        assertEquals(1L, resultado.getId());
        assertEquals("CIT-TEST-001", resultado.getCodigoCita());
        assertEquals("PENDIENTE", resultado.getEstado());
    }
}
