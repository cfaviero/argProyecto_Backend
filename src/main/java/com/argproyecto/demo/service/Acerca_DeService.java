package com.argproyecto.demo.service;

import com.argproyecto.demo.model.Acerca_De;
import com.argproyecto.demo.repository.Acerca_DeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Acerca_DeService implements IAcerca_DeService{
    
    @Autowired
    public Acerca_DeRepository acercaRepo;
    
    @Override
    public List<Acerca_De> verAcerca_De() {
        return acercaRepo.findAll();
    }

    @Override
    public void crearAcerca_De(Acerca_De acerca) {
        acercaRepo.save(acerca);
    }

    @Override
    public void borrarAcerca_De(Long id) {
        acercaRepo.deleteById(id);
    }

    @Override
    public Acerca_De buscarAcerca_De(Long id) {
        return acercaRepo.findById(id).orElse(null);
    }

    @Override
    public void editarAcerca_De(Long id, Acerca_De acerca) {
        
        acercaRepo.findById(id).map( editAcerca -> {
        editAcerca.setDescripcion(acerca.getDescripcion());

        return acercaRepo.save(editAcerca); });
        
    }

    @Override
    public Boolean existsAcerca_De(Long id) {
        try {
            acercaRepo.findById(id);
                return true;
            } catch(Exception e){
                return false;
            }
        
    }
    
    
    
}
