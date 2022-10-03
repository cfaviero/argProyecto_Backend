package com.argproyecto.demo.Controller;

import com.argproyecto.demo.dto.DTOAcercaDe;
import com.argproyecto.demo.dto.Mensaje;
import com.argproyecto.demo.model.AcercaDe;
import com.argproyecto.demo.service.IAcercaDeService;
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
public class AcercaDeControl {
    
    @Autowired
    private IAcercaDeService acercaServ;
    

        @GetMapping("/acercade")
            public ResponseEntity<List<AcercaDe>> list(){
                List<AcercaDe> list = acercaServ.verAcercaDe();
                return new ResponseEntity(list, HttpStatus.OK);
            }


        @GetMapping("/acercade/{id}")
            public ResponseEntity<AcercaDe> getById(@PathVariable("id") Long id){
                if(!acercaServ.existsAcercaDe(id))
                    return new ResponseEntity(new Mensaje("No existe el Item buscado."), HttpStatus.NOT_FOUND);
                AcercaDe acerca = acercaServ.buscarAcercaDe(id);
                return new ResponseEntity(acerca, HttpStatus.OK);
            }
    
    @PreAuthorize("hasRole('ADMIN')")
        @PostMapping("/acercade")
        public ResponseEntity<?> create(@RequestBody DTOAcercaDe acercDTO){
            AcercaDe acercaNuevo = new AcercaDe(acercDTO.getDescripcion());
            acercaServ.crearAcercaDe(acercaNuevo);
            return new ResponseEntity(new Mensaje("Descripcion creada."), HttpStatus.OK);
        }

    @PreAuthorize("hasRole('ADMIN')")
        @DeleteMapping("/acercade/{id}")
        public ResponseEntity<?> delete(@PathVariable("id")Long id){
            if(!acercaServ.existsAcercaDe(id))
                return new ResponseEntity(new Mensaje("No existe el Item buscado."), HttpStatus.NOT_FOUND);
            acercaServ.borrarAcercaDe(id);
            return new ResponseEntity(new Mensaje("Descripcion eliminada."), HttpStatus.OK);
        }

    @PreAuthorize("hasRole('ADMIN')")
        @PutMapping("/acercade/{id}")
        public ResponseEntity<?> update(@PathVariable("id")Long id, @RequestBody DTOAcercaDe acercaDTO){
            if(!acercaServ.existsAcercaDe(id))
                return new ResponseEntity(new Mensaje("No existe el item buscado."), HttpStatus.NOT_FOUND);
            if(StringUtils.isBlank(acercaDTO.getDescripcion()))
                return new ResponseEntity(new Mensaje("Ingresar la descripcion es obligatorio."), HttpStatus.BAD_REQUEST);
            

            AcercaDe editAcer = acercaServ.buscarAcercaDe(id);
            editAcer.setDescripcion(acercaDTO.getDescripcion());
            acercaServ.crearAcercaDe(editAcer);
            return new ResponseEntity(new Mensaje("Descripcion actualizada."), HttpStatus.OK);
        }
    
}
