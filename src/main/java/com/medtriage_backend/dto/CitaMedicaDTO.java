package com.medtriage_backend.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CitaMedicaDTO {

	private Long id;
	private String codigoCita;
	private Long pacienteId;
	private String NombrePaciente;
	private Long doctorId;
	private String NombreDoctor;
	private String nivelPrioridad;
	private String motivoConsulta;
	private String estado;
	private BigDecimal montoConsulta;
	private LocalDateTime fechaCita;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigoCita() {
		return codigoCita;
	}

	public void setCodigoCita(String codigoCita) {
		this.codigoCita = codigoCita;
	}

	public Long getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(Long pacienteId) {
		this.pacienteId = pacienteId;
	}

	public String getNombrePaciente() {
		return NombrePaciente;
	}

	public void setNombrePaciente(String NombrePaciente) {
		this.NombrePaciente = NombrePaciente;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public String getNombreDoctor() {
		return NombreDoctor;
	}

	public void setNombreDoctor(String NombreDoctor) {
		this.NombreDoctor = NombreDoctor;
	}

	public String getNivelPrioridad() {
		return nivelPrioridad;
	}

	public void setNivelPrioridad(String nivelPrioridad) {
		this.nivelPrioridad = nivelPrioridad;
	}

	public String getMotivoConsulta() {
		return motivoConsulta;
	}

	public void setMotivoConsulta(String motivoConsulta) {
		this.motivoConsulta = motivoConsulta;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public BigDecimal getMontoConsulta() {
		return montoConsulta;
	}

	public void setMontoConsulta(BigDecimal montoConsulta) {
		this.montoConsulta = montoConsulta;
	}

	public LocalDateTime getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(LocalDateTime fechaCita) {
		this.fechaCita = fechaCita;
	}
    
}
