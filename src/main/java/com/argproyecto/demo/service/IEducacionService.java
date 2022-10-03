package com.argproyecto.demo.service;

import com.argproyecto.demo.model.Educacion;
import java.util.List;


public interface IEducacionService {
    
    public List<Educacion> verEducaciones ();
    public void crearEducacion (Educacion edu);
    public void borrarEducacion (Long id);
    public Educacion buscarEducacion (Long id);
    public void editarEducacion (Long id, Educacion edu);
    public Boolean existsEducacion(Long id);
    
}
