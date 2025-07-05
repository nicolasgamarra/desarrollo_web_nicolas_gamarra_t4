package com.tarea4.tarea4.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="actividad")
public class Actividad {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    @Column(name= "fecha_inicio")
    private LocalDateTime fechaInicio;

    @NotNull
    @Column(name= "fecha_termino")
    private LocalDateTime fechaTermino;

    @NotNull
    private String sector;

    @NotNull
    private String nombre;

    @NotNull
    private String tema;

    @OneToMany(mappedBy= "actividad",
               cascade=CascadeType.ALL,
               fetch= FetchType.LAZY)
    private List<Nota> notas = new ArrayList<>();

    public Double getPromedio() {
        return notas.isEmpty()
             ? null
             : notas.stream()
                    .mapToInt(n -> n.getValor())   
                    .average()
                    .orElse(0);
    }


    public Integer getId(){ return id; }
    public LocalDateTime getFechaInicio(){ return fechaInicio; }
    public LocalDateTime getFechaTermino(){ return fechaTermino; }
    public String getSector(){ return sector; }
    public String getNombre(){ return nombre; }
    public String getTema(){ return tema; }
    public List<Nota> getNotas(){ return notas; }

    public void setFechaInicio(LocalDateTime fechaInicio) {this.fechaInicio= fechaInicio; }
    public void setFechaTermino(LocalDateTime fechaTermino){this.fechaTermino= fechaTermino; }
    public void setSector(String sector){ this.sector = sector; }
    public void setNombre(String nombre){ this.nombre = nombre; }
    public void setTema(String tema){ this.tema = tema; }
    public void setNotas(List<Nota> notas){ this.notas = notas; }
}
