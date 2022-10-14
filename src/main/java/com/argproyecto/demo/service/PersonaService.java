
package com.argproyecto.demo.service;

import com.argproyecto.demo.model.Persona;
import com.argproyecto.demo.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService{
    
    @Autowired
    public PersonaRepository persoRepo;
    
    @Override
    public List<Persona> verPersonas() {
        return persoRepo.findAll();
    }

    @Override
    public void crearPersona(Persona per) {
        persoRepo.save(per);
    }

    @Override
    public void borrarPersona(Long id) {
        persoRepo.deleteById(id);
    }

    @Override
    public Persona buscarPersona(Long id) {
        return persoRepo.findById(id).orElse(null);
    }

    @Override
    public void editarPersona(Long id, Persona per) {
        
        persoRepo.findById(id).map( editPerso -> {
        editPerso.setNombre(per.getNombre());
        editPerso.setApellido(per.getApellido());
        editPerso.setDescripcion(per.getDescripcion());
        editPerso.setFoto_perfil(per.getFoto_perfil());
        editPerso.setFoto_banner(per.getFoto_banner());
        editPerso.setUrl_instagram(per.getUrl_instagram());
        editPerso.setUrl_twitter(per.getUrl_twitter());
        editPerso.setUrl_facebook(per.getUrl_facebook());

        return persoRepo.save(editPerso); });
        
    }

    @Override
    public Boolean existsPersona(Long id) {
        
        try {
            persoRepo.findById(id);
                return true;
            } catch(Exception e){
                return false;
            }
        
    }
    
    
    
}
