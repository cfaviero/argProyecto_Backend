package com.argproyecto.demo.service;

import com.argproyecto.demo.model.Experiencia_Laboral;
import com.argproyecto.demo.repository.Experiencia_LaboralRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Experiencia_LaboralService implements IExp_LaboralService{
    
    @Autowired
    public Experiencia_LaboralRepository expRepo;
    
    @Override
    public List<Experiencia_Laboral> verExperiencia() {
        return expRepo.findAll();
    }

    @Override
    public void crearExperiencia(Experiencia_Laboral exp) {
        expRepo.save(exp);
    }

    @Override
    public void borrarExperiencia(Long id) {
        expRepo.deleteById(id);
    }

    @Override
    public Experiencia_Laboral buscarExperiencia(Long id) {
        return expRepo.findById(id).orElse(null);
    }

    @Override
    public void editarExperiencia(Long id, Experiencia_Laboral Exp) {
        expRepo.findById(id).map( editExp -> {
         editExp.setNombreEmpresa(Exp.getNombreEmpresa());
         editExp.setFechaInicio(Exp.getFechaInicio());
         editExp.setEsTrabajoActual(Exp.getEsTrabajoActual());
         editExp.setDescripcion(Exp.getDescripcion());
         editExp.setImagen(Exp.getImagen());

         return expRepo.save(editExp);
      });
    }

    @Override
    public Boolean existsExperiencia(Long id) {
        try {
            expRepo.findById(id);
                return true;
            } catch(Exception e){
                return false;
            }
    }
    
    
    
}
