package com.argproyecto.demo.Controller;

import com.argproyecto.demo.dto.DTOIntereses;
import com.argproyecto.demo.dto.Mensaje;
import com.argproyecto.demo.model.Intereses;
import com.argproyecto.demo.service.IInteresesService;
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
public class InteresesControl {
    
    @Autowired
    private IInteresesService interService;
    
    
    

        @GetMapping("/intereses")
            public ResponseEntity<List<Intereses>> list(){
                List<Intereses> list = interService.verIntereses();
                return new ResponseEntity(list, HttpStatus.OK);
            }


        @GetMapping("/interes/{id}")
            public ResponseEntity<Intereses> getById(@PathVariable("id") Long id){
                if(!interService.existsInteres(id))
                    return new ResponseEntity(new Mensaje("No existe el Item buscado."), HttpStatus.NOT_FOUND);
                Intereses interes = interService.buscarInteres(id);
                return new ResponseEntity(interes, HttpStatus.OK);
            }
    
    @PreAuthorize("hasRole('ADMIN')")
        @PostMapping("/interes")
        public ResponseEntity<?> create(@RequestBody DTOIntereses inter){
            Intereses interesNuevo = new Intereses( inter.getNombreInteres(), inter.getIconoInteres());
            interService.crearInteres(interesNuevo);
            return new ResponseEntity(new Mensaje("Interes creado."), HttpStatus.OK);
        }

   @PreAuthorize("hasRole('ADMIN')")
        @DeleteMapping("/interes/{id}")
        public ResponseEntity<?> delete(@PathVariable("id")Long id){
            if(!interService.existsInteres(id))
                return new ResponseEntity(new Mensaje("No existe el Item buscado."), HttpStatus.NOT_FOUND);
            interService.borrarInteres(id);
            return new ResponseEntity(new Mensaje("Interes eliminado."), HttpStatus.OK);
        }

    @PreAuthorize("hasRole('ADMIN')")
        @PutMapping("/interes/{id}")
        public ResponseEntity<?> update(@PathVariable("id")Long id, @RequestBody DTOIntereses interDto){
            if(!interService.existsInteres(id))
                return new ResponseEntity(new Mensaje("No existe el item buscado."), HttpStatus.NOT_FOUND);
            if(StringUtils.isBlank(interDto.getNombreInteres()))
                return new ResponseEntity(new Mensaje("Ingresar el nombre es obligatorio."), HttpStatus.BAD_REQUEST);
            if(StringUtils.isBlank(interDto.getIconoInteres()))
                return new ResponseEntity(new Mensaje("Ingresar el icono es obligatorio."), HttpStatus.BAD_REQUEST);
           

            Intereses editInter = interService.buscarInteres(id);
            editInter.setNombreInteres(interDto.getNombreInteres());
            editInter.setIconoInteres(interDto.getIconoInteres());
            interService.crearInteres(editInter);
            return new ResponseEntity(new Mensaje("Interes actualizado."), HttpStatus.OK);
        }
    
    
    
}
