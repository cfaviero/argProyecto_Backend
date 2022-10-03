package com.argproyecto.demo.service;

import com.argproyecto.demo.model.Conocimientos;
import com.argproyecto.demo.repository.ConocimientosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConocimientosService implements IConocimientosService{
    
    @Autowired
    public ConocimientosRepository conoRepo;
    
    @Override
    public List<Conocimientos> verConocimientos() {
        return conoRepo.findAll();
    }

    @Override
    public void crearConocimiento(Conocimientos cono) {
        conoRepo.save(cono);
    }

    @Override
    public void borrarConocimiento(Long id) {
        conoRepo.deleteById(id);
    }

    @Override
    public Conocimientos buscarConocimiento(Long id) {
        return conoRepo.findById(id).orElse(null);
    }

    @Override
    public void editarConocimiento(Long id, Conocimientos cono) {
        conoRepo.findById(id).map( editCono -> {
         editCono.setNombreCono(cono.getNombreCono());
         editCono.setNivelCono(cono.getNivelCono());

         return conoRepo.save(editCono); });
    }

    @Override
    public Boolean existsConocimiento(Long id) {
        try {
            conoRepo.findById(id);
                return true;
            } catch(Exception e){
                return false;
            }
    }
    
    
    
}
