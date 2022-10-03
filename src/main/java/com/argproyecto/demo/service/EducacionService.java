package com.argproyecto.demo.service;

import com.argproyecto.demo.model.Educacion;
import com.argproyecto.demo.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService{
    
    @Autowired
    public EducacionRepository eduRepo;
    
    @Override
    public List<Educacion> verEducaciones() {
        return eduRepo.findAll();
    }

    @Override
    public void crearEducacion(Educacion edu) {
        eduRepo.save(edu);
    }

    @Override
    public void borrarEducacion(Long id) {
        eduRepo.deleteById(id);
    }

    @Override
    public Educacion buscarEducacion(Long id) {
        return eduRepo.findById(id).orElse(null);
    }
    
    @Override
    public void editarEducacion (Long id, Educacion edu){
         eduRepo.findById(id).map( editEdu -> {
         editEdu.setCarrera_curso(edu.getCarrera_curso());
         editEdu.setInstituto(edu.getInstituto());
         editEdu.setFecha_inicio(edu.getFecha_inicio());
         editEdu.setEstado_actual(edu.getEstado_actual());
         editEdu.setDescripcion(edu.getDescripcion());

         return eduRepo.save(editEdu); });
    }
    
    @Override
    public Boolean existsEducacion(Long id){
                try {
                  eduRepo.findById(id);
                  return true;
                 } catch(Exception e){
                    return false;
                 }
           }
    
}
