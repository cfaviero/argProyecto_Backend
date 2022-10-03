package com.argproyecto.demo.service;

import com.argproyecto.demo.model.AcercaDe;
import java.util.List;


public interface IAcercaDeService {
    
    public List<AcercaDe> verAcercaDe ();
    public void crearAcercaDe (AcercaDe acerca);
    public void borrarAcercaDe (Long id);
    public AcercaDe buscarAcercaDe (Long id);
    public void editarAcercaDe (Long id, AcercaDe acerca);
    public Boolean existsAcercaDe(Long id);
    
}
