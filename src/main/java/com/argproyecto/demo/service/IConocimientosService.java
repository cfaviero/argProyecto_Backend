package com.argproyecto.demo.service;

import com.argproyecto.demo.model.Conocimientos;
import java.util.List;


public interface IConocimientosService {
    
    public List<Conocimientos> verConocimientos ();
    public void crearConocimiento (Conocimientos cono);
    public void borrarConocimiento (Long id);
    public Conocimientos buscarConocimiento (Long id);
    public void editarConocimiento (Long id, Conocimientos cono);
    public Boolean existsConocimiento(Long id);
    
}
