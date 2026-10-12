package com.medtriage_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.medtriage_backend.dto.CitaMedicaDTO;
import com.medtriage_backend.dto.CrearCitaDTO;
import com.medtriage_backend.model.CitaMedica;
import com.medtriage_backend.model.Doctor;
import com.medtriage_backend.model.Paciente;
import com.medtriage_backend.repository.CitaMedicaRepository;
import com.medtriage_backend.repository.DoctorRepository;
import com.medtriage_backend.repository.PacienteRepository;

@Service
public class CitaMedicaService {

	private final CitaMedicaRepository citaMedicaRepository;
	private final DoctorRepository doctorRepository;
	private final PacienteRepository pacienteRepository;

	public CitaMedicaService(CitaMedicaRepository citaMedicaRepository,
			DoctorRepository doctorRepository, PacienteRepository pacienteRepository) {
		this.citaMedicaRepository = citaMedicaRepository;
		this.doctorRepository = doctorRepository;
		this.pacienteRepository = pacienteRepository;
	}

	public List<CitaMedicaDTO> listar() {
		return citaMedicaRepository.findAll().stream().map(this::convertirADTO).toList();
	}

	public CitaMedicaDTO buscarPorId(Long id) {
		CitaMedica cita = citaMedicaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Cita no encontrada"));
		return convertirADTO(cita);
	}

	public CitaMedicaDTO crear(CrearCitaDTO datos) {
		CitaMedica cita = new CitaMedica();
		copiarDatos(cita, datos);
		cita.setEstado("PENDIENTE");
		return convertirADTO(citaMedicaRepository.save(cita));
	}

	public CitaMedicaDTO actualizar(Long id, CrearCitaDTO datos) {
		CitaMedica cita = citaMedicaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Cita no encontrada"));
		copiarDatos(cita, datos);
		return convertirADTO(citaMedicaRepository.save(cita));
	}

	public void eliminar(Long id) {
		citaMedicaRepository.deleteById(id);
	}

	private void copiarDatos(CitaMedica cita, CrearCitaDTO datos) {
		Doctor doctor = doctorRepository.findById(datos.getDoctorId())
				.orElseThrow(() -> new RuntimeException("Doctor no encontrado"));
		Paciente paciente = pacienteRepository.findById(datos.getPacienteId())
				.orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

		cita.setCodigoCita(datos.getCodigoCita());
		cita.setDoctor(doctor);
		cita.setPaciente(paciente);
		cita.setNivelPrioridad(datos.getNivelPrioridad());
		cita.setMotivoConsulta(datos.getMotivoConsulta());
		cita.setMontoConsulta(datos.getMontoConsulta());
		cita.setFechaCita(datos.getFechaCita());
	}

	private CitaMedicaDTO convertirADTO(CitaMedica cita) {
		CitaMedicaDTO dto = new CitaMedicaDTO();
		dto.setId(cita.getId());
		dto.setCodigoCita(cita.getCodigoCita());
		dto.setPacienteId(cita.getPaciente().getId());
		dto.setNombrePaciente(cita.getPaciente().getNombreCompleto());
		dto.setDoctorId(cita.getDoctor().getId());
		dto.setNombreDoctor(cita.getDoctor().getNombre());
		dto.setNivelPrioridad(cita.getNivelPrioridad());
		dto.setMotivoConsulta(cita.getMotivoConsulta());
		dto.setEstado(cita.getEstado());
		dto.setMontoConsulta(cita.getMontoConsulta());
		dto.setFechaCita(cita.getFechaCita());
		return dto;
	}
}
