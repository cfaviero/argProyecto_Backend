package com.argproyecto.demo.service;

import com.argproyecto.demo.model.AcercaDe;
import com.argproyecto.demo.repository.AcercaDeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcercaDeService implements IAcercaDeService{
    
    @Autowired
    public AcercaDeRepository acercaRepo;
    
    @Override
    public List<AcercaDe> verAcercaDe() {
        return acercaRepo.findAll();
    }

    @Override
    public void crearAcercaDe(AcercaDe acerca) {
        acercaRepo.save(acerca);
    }

    @Override
    public void borrarAcercaDe(Long id) {
        acercaRepo.deleteById(id);
    }

    @Override
    public AcercaDe buscarAcercaDe(Long id) {
        return acercaRepo.findById(id).orElse(null);
    }

    @Override
    public void editarAcercaDe(Long id, AcercaDe acerca) {
        
        acercaRepo.findById(id).map( editAcerca -> {
        editAcerca.setDescripcion(acerca.getDescripcion());

        return acercaRepo.save(editAcerca); });
        
    }

    @Override
    public Boolean existsAcercaDe(Long id) {
        try {
            acercaRepo.findById(id);
                return true;
            } catch(Exception e){
                return false;
            }
        
    }
    
    
    
}
