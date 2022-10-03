package com.argproyecto.demo.service;

import com.argproyecto.demo.model.Experiencia_Laboral;
import java.util.List;


public interface IExp_LaboralService {
    
    public List<Experiencia_Laboral> verExperiencia ();
    public void crearExperiencia (Experiencia_Laboral Exp);
    public void borrarExperiencia (Long id);
    public Experiencia_Laboral buscarExperiencia (Long id);
    public void editarExperiencia (Long id, Experiencia_Laboral Exp);
    public Boolean existsExperiencia(Long id);
    
}
