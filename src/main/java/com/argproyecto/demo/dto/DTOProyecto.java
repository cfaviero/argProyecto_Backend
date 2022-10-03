package com.argproyecto.demo.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DTOProyecto {
    @NotBlank
    private String nombreProyecto;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String url_proyecto;

    public DTOProyecto() {
    }

    public DTOProyecto(@NotBlank String nombreProyecto, @NotBlank String descripcion, @NotBlank String url_proyecto) {
        this.nombreProyecto = nombreProyecto;
        this.descripcion = descripcion;
        this.url_proyecto = url_proyecto;
    }
    
    
    
}
