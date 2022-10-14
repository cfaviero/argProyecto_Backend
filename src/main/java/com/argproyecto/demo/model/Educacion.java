package com.argproyecto.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String carrera_curso;
    private String instituto;
    private String fecha_inicio;
    private String estado_actual;
    private String descripcion;
    private String url_imagen;

    
    
    public Educacion() {
    }

    public Educacion(String carrera_curso, String instituto, String fecha_inicio, String estado_actual, String descripcion, String url_imagen) {
        this.carrera_curso = carrera_curso;
        this.instituto = instituto;
        this.fecha_inicio = fecha_inicio;
        this.estado_actual = estado_actual;
        this.descripcion = descripcion;
        this.url_imagen = url_imagen;
    }
    
    
    
    
    
}
