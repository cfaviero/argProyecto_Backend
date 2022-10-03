package com.argproyecto.demo.Controller;

import com.argproyecto.demo.dto.DTOConocimientos;
import com.argproyecto.demo.dto.Mensaje;
import com.argproyecto.demo.model.Conocimientos;
import com.argproyecto.demo.service.IConocimientosService;
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
public class ConocimientosControl {
    
    @Autowired
    private IConocimientosService conoServ;
    
    

        @GetMapping("/conocimientos")
            public ResponseEntity<List<Conocimientos>> list(){
                List<Conocimientos> list = conoServ.verConocimientos();
                return new ResponseEntity(list, HttpStatus.OK);
            }


        @GetMapping("/conocimiento/{id}")
            public ResponseEntity<Conocimientos> getById(@PathVariable("id") Long id){
                if(!conoServ.existsConocimiento(id))
                    return new ResponseEntity(new Mensaje("No existe el Item buscado."), HttpStatus.NOT_FOUND);
                Conocimientos cono = conoServ.buscarConocimiento(id);
                return new ResponseEntity(cono, HttpStatus.OK);
            }
    
    @PreAuthorize("hasRole('ADMIN')")
        @PostMapping("/conocimiento")
        public ResponseEntity<?> create(@RequestBody DTOConocimientos conoc){
            Conocimientos conoNuevo = new Conocimientos(conoc.getNombreCono(), conoc.getNivelCono());
            conoServ.crearConocimiento(conoNuevo);
            return new ResponseEntity(new Mensaje("Conocimiento creado."), HttpStatus.OK);
        }

    @PreAuthorize("hasRole('ADMIN')")
        @DeleteMapping("/conocimiento/{id}")
        public ResponseEntity<?> delete(@PathVariable("id")Long id){
            if(!conoServ.existsConocimiento(id))
                return new ResponseEntity(new Mensaje("No existe el Item buscado."), HttpStatus.NOT_FOUND);
            conoServ.borrarConocimiento(id);
            return new ResponseEntity(new Mensaje("Conocimiento eliminado."), HttpStatus.OK);
        }

    @PreAuthorize("hasRole('ADMIN')")
        @PutMapping("/conocimiento/{id}")
        public ResponseEntity<?> update(@PathVariable("id")Long id, @RequestBody DTOConocimientos eduDto){
            if(!conoServ.existsConocimiento(id))
                return new ResponseEntity(new Mensaje("No existe el item buscado."), HttpStatus.NOT_FOUND);
            if(StringUtils.isBlank(eduDto.getNombreCono()))
                return new ResponseEntity(new Mensaje("Ingresar el nombre es obligatorio."), HttpStatus.BAD_REQUEST);
            if(StringUtils.isBlank(eduDto.getNivelCono()))
                return new ResponseEntity(new Mensaje("Ingresar el nivel es obligatorio."), HttpStatus.BAD_REQUEST);
            

            Conocimientos editExp = conoServ.buscarConocimiento(id);
            editExp.setNombreCono(eduDto.getNombreCono());
            editExp.setNivelCono(eduDto.getNivelCono());
            conoServ.crearConocimiento(editExp);
            return new ResponseEntity(new Mensaje("Conocimiento actualizado."), HttpStatus.OK);
        }
    
    
}
