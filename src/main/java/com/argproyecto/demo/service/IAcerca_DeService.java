package com.argproyecto.demo.service;

import com.argproyecto.demo.model.Acerca_De;
import java.util.List;


public interface IAcerca_DeService {
    
    public List<Acerca_De> verAcerca_De ();
    public void crearAcerca_De (Acerca_De acerca);
    public void borrarAcerca_De (Long id);
    public Acerca_De buscarAcerca_De (Long id);
    public void editarAcerca_De (Long id, Acerca_De acerca);
    public Boolean existsAcerca_De(Long id);
    
}
