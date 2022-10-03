package com.argproyecto.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Experiencia_Laboral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreEmpresa;
    private String fechaInicio;
    private String esTrabajoActual;
    private String descripcion;
    private String imagen;

    public Experiencia_Laboral() {
    }

    public Experiencia_Laboral(String nombreEmpresa, String fechaInicio, String esTrabajoActual, String descripcion, String imagen) {
        this.nombreEmpresa = nombreEmpresa;
        this.fechaInicio = fechaInicio;
        this.esTrabajoActual = esTrabajoActual;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }
    
    
    
    
}
