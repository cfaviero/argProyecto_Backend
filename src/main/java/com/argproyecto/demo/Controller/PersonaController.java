
package com.argproyecto.demo.Controller;

import com.argproyecto.demo.dto.DTOPersona;
import com.argproyecto.demo.dto.Mensaje;
import com.argproyecto.demo.model.Persona;
import com.argproyecto.demo.service.IPersonaService;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PersonaController {
    
    @Autowired
    private IPersonaService persoServ;
    
    

        @GetMapping("/personas")
            public ResponseEntity<List<Persona>> list(){
                List<Persona> list = persoServ.verPersonas();
                return new ResponseEntity(list, HttpStatus.OK);
            }

        @GetMapping("/persona/{id}")
            public ResponseEntity<Persona> getById(@PathVariable("id") Long id){
                if(!persoServ.existsPersona(id))
                    return new ResponseEntity(new Mensaje("No existe el Item buscado."), HttpStatus.NOT_FOUND);
                Persona persona = persoServ.buscarPersona(id);
                return new ResponseEntity(persona, HttpStatus.OK);
            }
    
    @PreAuthorize("hasRole('ADMIN')")
        @PostMapping("/persona")
        public ResponseEntity<?> create(@RequestBody DTOPersona pers){
            Persona personaNuevo = new Persona(pers.getNombre(), pers.getApellido(), pers.getDescripción(), pers.getFoto_perfil(), pers.getFoto_banner(), pers.getUrl_instagram(), pers.getUrl_twitter(), pers.getUrl_facebook());
            persoServ.crearPersona(personaNuevo);
            return new ResponseEntity(new Mensaje("Persona creada"), HttpStatus.OK);
        }

    @PreAuthorize("hasRole('ADMIN')")
        @DeleteMapping("/persona/{id}")
        public ResponseEntity<?> delete(@PathVariable("id")Long id){
            if(!persoServ.existsPersona(id))
                return new ResponseEntity(new Mensaje("No existe el Item buscado."), HttpStatus.NOT_FOUND);
            persoServ.borrarPersona(id);
            return new ResponseEntity(new Mensaje("Item Persona eliminado."), HttpStatus.OK);
        }

     
    @PreAuthorize("hasRole('ADMIN')")
        @PutMapping("/persona/{id}")
        public ResponseEntity<?> update(@PathVariable("id")Long id, @RequestBody DTOPersona personaDTO){
            if(!persoServ.existsPersona(id))
                return new ResponseEntity(new Mensaje("No existe el item buscado."), HttpStatus.NOT_FOUND);
            if(StringUtils.isBlank(personaDTO.getNombre()))
                return new ResponseEntity(new Mensaje("Ingresar el nombre es obligatorio."), HttpStatus.BAD_REQUEST);
            if(StringUtils.isBlank(personaDTO.getApellido()))
                return new ResponseEntity(new Mensaje("Ingresar la apellido es obligatorio."), HttpStatus.BAD_REQUEST);
            if(StringUtils.isBlank(personaDTO.getDescripción()))
                return new ResponseEntity(new Mensaje("Ingresar la Descripcion es obligatorio."), HttpStatus.BAD_REQUEST);
            if(StringUtils.isBlank(personaDTO.getFoto_perfil()))
                return new ResponseEntity(new Mensaje("Ingresar la foto de perfil es obligatorio."), HttpStatus.BAD_REQUEST);
            if(StringUtils.isBlank(personaDTO.getFoto_banner()))
                return new ResponseEntity(new Mensaje("Ingresar el banner es obligatorio."), HttpStatus.BAD_REQUEST);
            
            Persona editPerso = persoServ.buscarPersona(id);
            editPerso.setNombre(personaDTO.getNombre());
            editPerso.setApellido(personaDTO.getApellido());
            editPerso.setDescripción(personaDTO.getDescripción());
            editPerso.setFoto_perfil(personaDTO.getFoto_perfil());
            editPerso.setFoto_banner(personaDTO.getFoto_banner());
            editPerso.setUrl_instagram(personaDTO.getUrl_instagram());
            editPerso.setUrl_twitter(personaDTO.getUrl_twitter());
            editPerso.setUrl_facebook(personaDTO.getUrl_facebook());
            persoServ.crearPersona(editPerso);
            return new ResponseEntity(new Mensaje("Item Persona actualizado."), HttpStatus.OK);
        
        }
}
