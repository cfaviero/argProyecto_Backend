package com.argproyecto.demo.Controller;

import com.argproyecto.demo.dto.DTOEducacion;
import com.argproyecto.demo.dto.Mensaje;
import com.argproyecto.demo.model.Educacion;
import com.argproyecto.demo.service.IEducacionService;
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
public class EducacionControl {
    
    @Autowired
    private IEducacionService eduService;
    
    

        @GetMapping("/educaciones")
            public ResponseEntity<List<Educacion>> list(){
                List<Educacion> list = eduService.verEducaciones();
                return new ResponseEntity(list, HttpStatus.OK);
            }


        @GetMapping("/educacion/{id}")
            public ResponseEntity<Educacion> getById(@PathVariable("id") Long id){
                if(!eduService.existsEducacion(id))
                    return new ResponseEntity(new Mensaje("No existe el Item buscado."), HttpStatus.NOT_FOUND);
                Educacion edu = eduService.buscarEducacion(id);
                return new ResponseEntity(edu, HttpStatus.OK);
            }
    
    @PreAuthorize("hasRole('ADMIN')")
        @PostMapping("/educacion")
        public ResponseEntity<?> create(@RequestBody DTOEducacion educ){
            Educacion eduNuevo = new Educacion(educ.getCarrera_curso(), educ.getInstituto(), educ.getFecha_inicio(), educ.getEstado_actual(), educ.getDescripcion());
            eduService.crearEducacion(eduNuevo);
            return new ResponseEntity(new Mensaje("Educación creada."), HttpStatus.OK);
        }

    @PreAuthorize("hasRole('ADMIN')")
        @DeleteMapping("/educacion/{id}")
        public ResponseEntity<?> delete(@PathVariable("id")Long id){
            if(!eduService.existsEducacion(id))
                return new ResponseEntity(new Mensaje("No existe el Item buscado."), HttpStatus.NOT_FOUND);
            eduService.borrarEducacion(id);
            return new ResponseEntity(new Mensaje("Educación eliminada."), HttpStatus.OK);
        }

    @PreAuthorize("hasRole('ADMIN')")
        @PutMapping("/educacion/{id}")
        public ResponseEntity<?> update(@PathVariable("id")Long id, @RequestBody DTOEducacion eduDto){
            if(!eduService.existsEducacion(id))
                return new ResponseEntity(new Mensaje("No existe el item buscado."), HttpStatus.NOT_FOUND);
            if(StringUtils.isBlank(eduDto.getCarrera_curso()))
                return new ResponseEntity(new Mensaje("Ingresar el nombre es obligatorio."), HttpStatus.BAD_REQUEST);
            if(StringUtils.isBlank(eduDto.getInstituto()))
                return new ResponseEntity(new Mensaje("Ingresar el instituto es obligatorio."), HttpStatus.BAD_REQUEST);
            if(StringUtils.isBlank(eduDto.getFecha_inicio()))
                return new ResponseEntity(new Mensaje("Ingresar la fecha de inicio es obligatorio."), HttpStatus.BAD_REQUEST);
            if(StringUtils.isBlank(eduDto.getEstado_actual()))
                return new ResponseEntity(new Mensaje("Ingresar el estado actual es obligatorio."), HttpStatus.BAD_REQUEST);
            if(StringUtils.isBlank(eduDto.getDescripcion()))
                return new ResponseEntity(new Mensaje("Ingresar la descripción es obligatorio."), HttpStatus.BAD_REQUEST);
            

            Educacion editExp = eduService.buscarEducacion(id);
            editExp.setCarrera_curso(eduDto.getCarrera_curso());
            editExp.setInstituto(eduDto.getInstituto());
            editExp.setFecha_inicio(eduDto.getFecha_inicio());
            editExp.setEstado_actual(eduDto.getEstado_actual());
            editExp.setDescripcion(eduDto.getDescripcion());
            eduService.crearEducacion(editExp);
            return new ResponseEntity(new Mensaje("Educación actualizada."), HttpStatus.OK);
        }
    
    
    
}
