package com.argproyecto.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Intereses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreInteres;
    private String iconoInteres;

    
    public Intereses() {
    }

    public Intereses(String nombreInteres, String iconoInteres) {
        this.nombreInteres = nombreInteres;
        this.iconoInteres = iconoInteres;
    }
    
    
    
}
