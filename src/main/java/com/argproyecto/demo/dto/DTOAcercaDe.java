package com.argproyecto.demo.dto;


import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DTOAcercaDe {
    
    @NotBlank
    private String descripcion;

    public DTOAcercaDe() {
    }
    
    public DTOAcercaDe(@NotBlank String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
