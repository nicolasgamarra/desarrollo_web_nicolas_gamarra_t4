package com.tarea4.tarea4.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name ="nota")
public class Nota {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name= "actividad_id")
    private Actividad actividad;

    @Column(name="nota")          
    @NotNull
    @Min(1)
    @Max(7)
    private Integer valor;

    public Integer getId() {
        return id;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public Integer getValor() {
        return valor;
    }




    public void setActividad(Actividad actividad) {
        this.actividad= actividad;
    }

    public void setValor(Integer valor) {
        this.valor= valor;
    }
}
