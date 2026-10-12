package com.medtriage_backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medtriage_backend.dto.CitaMedicaDTO;
import com.medtriage_backend.dto.CrearCitaDTO;
import com.medtriage_backend.service.CitaMedicaService;

@RestController
@RequestMapping("/api/citas")
public class CitaMedicaController {

    private final CitaMedicaService citaMedicaService;

    public CitaMedicaController(CitaMedicaService citaMedicaService) {
        this.citaMedicaService = citaMedicaService;
    }

    @GetMapping
    public List<CitaMedicaDTO> listar() {
        return citaMedicaService.listar();
    }

    @GetMapping("/{id}")
    public CitaMedicaDTO buscarPorId(@PathVariable Long id) {
        return citaMedicaService.buscarPorId(id);
    }

    @PostMapping
    public CitaMedicaDTO crear(@RequestBody CrearCitaDTO datos) {
        return citaMedicaService.crear(datos);
    }

    @PutMapping("/{id}")
    public CitaMedicaDTO actualizar(@PathVariable Long id, @RequestBody CrearCitaDTO datos) {
        return citaMedicaService.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        citaMedicaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}