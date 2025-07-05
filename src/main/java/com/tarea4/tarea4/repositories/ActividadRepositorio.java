package com.tarea4.tarea4.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tarea4.tarea4.models.Actividad;

public interface ActividadRepositorio
        extends JpaRepository<Actividad, Integer> {

    List<Actividad> findByFechaTerminoBeforeOrderByFechaTerminoDesc(
            LocalDateTime fechaLimite);
}
