package com.argproyecto.demo.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DTOEducacion {
    

    @NotBlank
    private String carrera_curso;
    @NotBlank
    private String instituto;
    @NotBlank
    private String fecha_inicio;
    @NotBlank
    private String estado_actual;
    @NotBlank
    private String descripcion;

    public DTOEducacion() {
    }

    public DTOEducacion(@NotBlank String carrera_curso, @NotBlank String instituto, @NotBlank String fecha_inicio, @NotBlank String estado_actual, @NotBlank String descripcion) {
        this.carrera_curso = carrera_curso;
        this.instituto = instituto;
        this.fecha_inicio = fecha_inicio;
        this.estado_actual = estado_actual;
        this.descripcion = descripcion;
    }
    
    
    
}
