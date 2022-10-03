package com.argproyecto.demo.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DTOIntereses {
    @NotBlank
    private String nombreInteres;
    @NotBlank
    private String iconoInteres;

    public DTOIntereses() {
    }

    public DTOIntereses(@NotBlank String nombreInteres, @NotBlank String iconoInteres) {
        this.nombreInteres = nombreInteres;
        this.iconoInteres = iconoInteres;
    }
    
    
    
}
