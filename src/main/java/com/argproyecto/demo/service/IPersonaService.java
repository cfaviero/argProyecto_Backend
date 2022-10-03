
package com.argproyecto.demo.service;

import com.argproyecto.demo.model.Persona;
import java.util.List;


public interface IPersonaService {
    
    public List<Persona> verPersonas ();
    public void crearPersona (Persona per);
    public void borrarPersona (Long id);
    public Persona buscarPersona (Long id);
    public void editarPersona (Long id, Persona per);
    public Boolean existsPersona(Long id);
    
}
