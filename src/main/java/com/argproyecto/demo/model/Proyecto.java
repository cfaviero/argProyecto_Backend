package com.argproyecto.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreProyecto;
    private String descripcion;
    private String url_proyecto;

    public Proyecto() {
    }

    public Proyecto(String nombreProyecto, String descripcion, String url_proyecto) {
        this.nombreProyecto = nombreProyecto;
        this.descripcion = descripcion;
        this.url_proyecto = url_proyecto;
    }
    
    
    
}
