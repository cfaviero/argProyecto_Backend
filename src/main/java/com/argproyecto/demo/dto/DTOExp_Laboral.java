package com.argproyecto.demo.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DTOExp_Laboral {
    @NotBlank
    private String nombreEmpresa;
    @NotBlank
    private String fechaInicio;
    @NotBlank
    private String esTrabajoActual;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String imagen;

    
    
    public DTOExp_Laboral() {
    }

    public DTOExp_Laboral(@NotBlank String nombreEmpresa, @NotBlank String fechaInicio, @NotBlank String esTrabajoActual, @NotBlank String descripcion, @NotBlank String imagen) {
        this.nombreEmpresa = nombreEmpresa;
        this.fechaInicio = fechaInicio;
        this.esTrabajoActual = esTrabajoActual;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    
    
    
    
}
