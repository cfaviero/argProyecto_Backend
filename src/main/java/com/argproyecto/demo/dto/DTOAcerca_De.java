package com.argproyecto.demo.dto;


import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DTOAcerca_De {
    
    @NotBlank
    private String descripcion;

    public DTOAcerca_De() {
    }
    
    public DTOAcerca_De(@NotBlank String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
