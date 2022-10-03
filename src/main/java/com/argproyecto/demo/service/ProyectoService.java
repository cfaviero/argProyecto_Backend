package com.argproyecto.demo.service;

import com.argproyecto.demo.model.Proyecto;
import com.argproyecto.demo.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService{
    
    @Autowired
    public ProyectoRepository proRepo;
    
    @Override
    public List<Proyecto> verProyectos() {
        return proRepo.findAll();
    }

    @Override
    public void crearProyecto(Proyecto pro) {
        proRepo.save(pro);
    }

    @Override
    public void borrarProyecto(Long id) {
        proRepo.deleteById(id);
    }

    @Override
    public Proyecto buscarProyecto(Long id) {
        return proRepo.findById(id).orElse(null);
    }

    @Override
    public void editarProyecto(Long id, Proyecto pro) {
        
        proRepo.findById(id).map( editPro -> {
        editPro.setNombreProyecto(pro.getNombreProyecto());
        editPro.setDescripcion(pro.getDescripcion());
        editPro.setUrl_proyecto(pro.getUrl_proyecto());

        return proRepo.save(editPro); });
        
    }

    @Override
    public Boolean existsProyecto(Long id) {
        
        try {
            proRepo.findById(id);
                return true;
            } catch(Exception e){
                return false;
            }
        
    }
    
    
    
}
