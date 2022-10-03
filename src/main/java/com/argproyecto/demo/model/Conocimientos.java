package com.argproyecto.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Conocimientos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreCono;
    private String nivelCono;

    
    
    public Conocimientos() {
    }

    public Conocimientos(String nombreCono, String nivelCono) {
        this.nombreCono = nombreCono;
        this.nivelCono = nivelCono;
    }
    
    
    
        
}
