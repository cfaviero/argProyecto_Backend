package com.argproyecto.demo.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DTOConocimientos {
    @NotBlank
    private String nombreCono;
    @NotBlank
    private String nivelCono;

    public DTOConocimientos() {
    }

    public DTOConocimientos(@NotBlank String nombreCono, @NotBlank String nivelCono) {
        this.nombreCono = nombreCono;
        this.nivelCono = nivelCono;
    }
    
    
    
}
