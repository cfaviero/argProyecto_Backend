package com.argproyecto.demo.service;

import com.argproyecto.demo.model.Proyecto;
import java.util.List;


public interface IProyectoService {
    
    public List<Proyecto> verProyectos ();
    public void crearProyecto (Proyecto pro);
    public void borrarProyecto (Long id);
    public Proyecto buscarProyecto (Long id);
    public void editarProyecto (Long id, Proyecto pro);
    public Boolean existsProyecto(Long id);
    
}
