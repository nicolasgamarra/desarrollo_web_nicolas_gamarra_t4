package com.tarea4.tarea4.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.tarea4.tarea4.models.Actividad;
import com.tarea4.tarea4.services.ActividadServicio;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@RestController
@RequestMapping("/api/actividades")
@Validated                     
public class ActividadRestController {
    private final ActividadServicio servicio;

    public ActividadRestController(ActividadServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/terminadas")
    public List<Actividad> terminadas() {
        return servicio.actividadesTerminadas();
    }

    @PostMapping("/{id}/notas")
    public ResponseEntity< Double> agregarNota(
            @PathVariable Integer id,
            @RequestBody @Min(1) @Max(7) Integer nota) {

        Double promedio= servicio.agregarNota(id, nota);
        return ResponseEntity.ok(promedio);
    }
}
