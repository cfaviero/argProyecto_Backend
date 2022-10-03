package com.argproyecto.demo.Controller;

import com.argproyecto.demo.dto.DTOExp_Laboral;
import com.argproyecto.demo.dto.Mensaje;
import com.argproyecto.demo.model.Experiencia_Laboral;
import com.argproyecto.demo.service.IExp_LaboralService;
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
public class ExpLabControl {
    
    @Autowired
    private IExp_LaboralService expService;
    
    

        @GetMapping("/experiencias")
            public ResponseEntity<List<Experiencia_Laboral>> list(){
                List<Experiencia_Laboral> list = expService.verExperiencia();
                return new ResponseEntity(list, HttpStatus.OK);
            }


        @GetMapping("/experiencia/{id}")
            public ResponseEntity<Experiencia_Laboral> getById(@PathVariable("id") Long id){
                if(!expService.existsExperiencia(id))
                    return new ResponseEntity(new Mensaje("No existe el Item buscado."), HttpStatus.NOT_FOUND);
                Experiencia_Laboral exp = expService.buscarExperiencia(id);
                return new ResponseEntity(exp, HttpStatus.OK);
            }
    
    @PreAuthorize("hasRole('ADMIN')")
        @PostMapping("/experiencia")
        public ResponseEntity<?> create(@RequestBody DTOExp_Laboral expe){
            Experiencia_Laboral expeNuevo = new Experiencia_Laboral(expe.getNombreEmpresa(), expe.getFechaInicio(), expe.getEsTrabajoActual(), expe.getDescripcion(), expe.getImagen());
            expService.crearExperiencia(expeNuevo);
            return new ResponseEntity(new Mensaje("Experiencia creada."), HttpStatus.OK);
        }

    @PreAuthorize("hasRole('ADMIN')")
        @DeleteMapping("/experiencia/{id}")
        public ResponseEntity<?> delete(@PathVariable("id")Long id){
            if(!expService.existsExperiencia(id))
                return new ResponseEntity(new Mensaje("No existe el Item buscado."), HttpStatus.NOT_FOUND);
            expService.borrarExperiencia(id);
            return new ResponseEntity(new Mensaje("Experiencia eliminada."), HttpStatus.OK);
        }

    @PreAuthorize("hasRole('ADMIN')")
        @PutMapping("/experiencia/{id}")
        public ResponseEntity<?> update(@PathVariable("id")Long id, @RequestBody DTOExp_Laboral experDto){
            if(!expService.existsExperiencia(id))
                return new ResponseEntity(new Mensaje("No existe el item buscado."), HttpStatus.NOT_FOUND);
            if(StringUtils.isBlank(experDto.getNombreEmpresa()))
                return new ResponseEntity(new Mensaje("Ingresar el nombre es obligatorio."), HttpStatus.BAD_REQUEST);
            if(StringUtils.isBlank(experDto.getFechaInicio()))
                return new ResponseEntity(new Mensaje("Ingresar la fecha es obligatorio."), HttpStatus.BAD_REQUEST);
            if(StringUtils.isBlank(experDto.getEsTrabajoActual()))
                return new ResponseEntity(new Mensaje("Ingresar el item es obligatorio."), HttpStatus.BAD_REQUEST);
            if(StringUtils.isBlank(experDto.getDescripcion()))
                return new ResponseEntity(new Mensaje("Ingresar la descripción es obligatorio."), HttpStatus.BAD_REQUEST);
            if(StringUtils.isBlank(experDto.getImagen()))
                return new ResponseEntity(new Mensaje("Ingresar imagen es obligatorio."), HttpStatus.BAD_REQUEST);
            

            Experiencia_Laboral editExp = expService.buscarExperiencia(id);
            editExp.setNombreEmpresa(experDto.getNombreEmpresa());
            editExp.setFechaInicio(experDto.getFechaInicio());
            editExp.setEsTrabajoActual(experDto.getEsTrabajoActual());
            editExp.setDescripcion(experDto.getDescripcion());
            editExp.setImagen(experDto.getImagen());
            expService.crearExperiencia(editExp);
            return new ResponseEntity(new Mensaje("Experiencia actualizada."), HttpStatus.OK);
        }
    
    
}
