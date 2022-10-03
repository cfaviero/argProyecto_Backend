
package com.argproyecto.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String nombre;
    private String apellido;
    private String descripción;
    private String foto_perfil;
    private String foto_banner;
    private String url_instagram;
    private String url_twitter;
    private String url_facebook;

    
    public Persona() {
    }

    public Persona(String nombre, String apellido, String descripción, String foto_perfil, String foto_banner, String url_instagram, String url_twitter, String url_facebook) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripción = descripción;
        this.foto_perfil = foto_perfil;
        this.foto_banner = foto_banner;
        this.url_instagram = url_instagram;
        this.url_twitter = url_twitter;
        this.url_facebook = url_facebook;
    }

    

    

    
    
    
    
    
    
}
