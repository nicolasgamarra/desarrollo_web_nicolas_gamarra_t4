package com.tarea4.tarea4.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tarea4.tarea4.models.Actividad;
import com.tarea4.tarea4.models.Nota;
import com.tarea4.tarea4.repositories.ActividadRepositorio;
import com.tarea4.tarea4.repositories.NotaRepositorio;

@Service
@Transactional
public class ActividadServicio {

    private final ActividadRepositorio actividadRepo;
    private final NotaRepositorio notaRepo;

    /** inyección por constructor (sin Lombok) */
    public ActividadServicio(ActividadRepositorio actividadRepo,
                             NotaRepositorio notaRepo) {
        this.actividadRepo= actividadRepo;
        this.notaRepo= notaRepo;
    }

    /** Actividades cuyo término ya pasó */
    public List<Actividad> actividadesTerminadas() {
        LocalDateTime ahora = LocalDateTime.now();
        return actividadRepo.findByFechaTerminoBeforeOrderByFechaTerminoDesc(ahora);
    }

    /** Agrega la nota y devuelve el nuevo promedio */
    public Double agregarNota(Integer idActividad, int valor) {

        Actividad act = actividadRepo.findById(idActividad)
                .orElseThrow(() -> new NoSuchElementException(
                        "Actividad " + idActividad+ " no existe"));

        Nota nota = new Nota();
        nota.setActividad(act);
        nota.setValor(valor);
        notaRepo.save(nota);

        return act.getPromedio();         
    }
}

