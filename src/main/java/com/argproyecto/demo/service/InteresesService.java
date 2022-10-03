package com.argproyecto.demo.service;

import com.argproyecto.demo.model.Intereses;
import com.argproyecto.demo.repository.InteresesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InteresesService implements IInteresesService{

    @Autowired
    public InteresesRepository interRepo;
    
    @Override
    public List<Intereses> verIntereses() {
        return interRepo.findAll();
    }

    @Override
    public void crearInteres(Intereses inter) {
        interRepo.save(inter);
    }

    @Override
    public void borrarInteres(Long id) {
        interRepo.deleteById(id);
    }

    @Override
    public Intereses buscarInteres(Long id) {
        return interRepo.findById(id).orElse(null);
    }

    @Override
    public void editarInteres(Long id, Intereses inter) {
        
        interRepo.findById(id).map( editInter -> {
        editInter.setNombreInteres(inter.getNombreInteres());
        editInter.setIconoInteres(inter.getIconoInteres());

        return interRepo.save(editInter); });
        
    }

    @Override
    public Boolean existsInteres(Long id) {
        
        try {
            interRepo.findById(id);
                return true;
            } catch(Exception e){
                return false;
            }
        
    }
    
    
    
}
