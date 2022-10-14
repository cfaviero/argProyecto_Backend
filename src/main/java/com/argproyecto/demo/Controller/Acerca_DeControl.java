package com.argproyecto.demo.Controller;

import com.argproyecto.demo.dto.DTOAcerca_De;
import com.argproyecto.demo.dto.Mensaje;
import com.argproyecto.demo.model.Acerca_De;
import com.argproyecto.demo.service.IAcerca_DeService;
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
public class Acerca_DeControl {
    
    @Autowired
    private IAcerca_DeService acercaServ;
    

        @GetMapping("/acerca_de")
            public ResponseEntity<List<Acerca_De>> list(){
                List<Acerca_De> list = acercaServ.verAcerca_De();
                return new ResponseEntity(list, HttpStatus.OK);
            }


        @GetMapping("/acerca_de/{id}")
            public ResponseEntity<Acerca_De> getById(@PathVariable("id") Long id){
                if(!acercaServ.existsAcerca_De(id))
                    return new ResponseEntity(new Mensaje("No existe el Item buscado."), HttpStatus.NOT_FOUND);
                Acerca_De acerca = acercaServ.buscarAcerca_De(id);
                return new ResponseEntity(acerca, HttpStatus.OK);
            }
    
    @PreAuthorize("hasRole('ADMIN')")
        @PostMapping("/acerca_de")
        public ResponseEntity<?> create(@RequestBody DTOAcerca_De acercDTO){
            Acerca_De acercaNuevo = new Acerca_De(acercDTO.getDescripcion());
            acercaServ.crearAcerca_De(acercaNuevo);
            return new ResponseEntity(new Mensaje("Descripcion creada."), HttpStatus.OK);
        }

    @PreAuthorize("hasRole('ADMIN')")
        @DeleteMapping("/acerca_de/{id}")
        public ResponseEntity<?> delete(@PathVariable("id")Long id){
            if(!acercaServ.existsAcerca_De(id))
                return new ResponseEntity(new Mensaje("No existe el Item buscado."), HttpStatus.NOT_FOUND);
            acercaServ.borrarAcerca_De(id);
            return new ResponseEntity(new Mensaje("Descripcion eliminada."), HttpStatus.OK);
        }

    @PreAuthorize("hasRole('ADMIN')")
        @PutMapping("/acerca_de/{id}")
        public ResponseEntity<?> update(@PathVariable("id")Long id, @RequestBody DTOAcerca_De acercaDTO){
            if(!acercaServ.existsAcerca_De(id))
                return new ResponseEntity(new Mensaje("No existe el item buscado."), HttpStatus.NOT_FOUND);
            if(StringUtils.isBlank(acercaDTO.getDescripcion()))
                return new ResponseEntity(new Mensaje("Ingresar la descripcion es obligatorio."), HttpStatus.BAD_REQUEST);
            

            Acerca_De editAcer = acercaServ.buscarAcerca_De(id);
            editAcer.setDescripcion(acercaDTO.getDescripcion());
            acercaServ.crearAcerca_De(editAcer);
            return new ResponseEntity(new Mensaje("Descripcion actualizada."), HttpStatus.OK);
        }
    
}
