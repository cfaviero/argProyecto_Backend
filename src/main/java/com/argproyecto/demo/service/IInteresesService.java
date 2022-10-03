package com.argproyecto.demo.service;

import com.argproyecto.demo.model.Intereses;
import java.util.List;


public interface IInteresesService {
    
    public List<Intereses> verIntereses ();
    public void crearInteres (Intereses inter);
    public void borrarInteres (Long id);
    public Intereses buscarInteres (Long id);
    public void editarInteres (Long id, Intereses inter);
    public Boolean existsInteres(Long id);
    
}
