package com.argproyecto.demo.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DTOPersona {
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String descripción;
    @NotBlank
    private String foto_perfil;
    @NotBlank
    private String foto_banner;
    
    private String url_instagram;
    
    private String url_twitter;
    
    private String url_facebook;

    public DTOPersona() {
    }

    public DTOPersona(String nombre, String apellido, String descripción, String foto_perfil, String foto_banner, String url_instagram, String url_twitter, String url_facebook) {
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
