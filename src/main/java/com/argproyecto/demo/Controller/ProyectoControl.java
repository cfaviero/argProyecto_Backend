package com.argproyecto.demo.Controller;

import com.argproyecto.demo.dto.DTOProyecto;
import com.argproyecto.demo.dto.Mensaje;
import com.argproyecto.demo.model.Proyecto;
import com.argproyecto.demo.service.IProyectoService;
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
public class ProyectoControl {
    
    @Autowired
    private IProyectoService proService;
    
    

        @GetMapping("/proyectos")
            public ResponseEntity<List<Proyecto>> list(){
                List<Proyecto> list = proService.verProyectos();
                return new ResponseEntity(list, HttpStatus.OK);
            }


        @GetMapping("/proyecto/{id}")
            public ResponseEntity<Proyecto> getById(@PathVariable("id") Long id){
                if(!proService.existsProyecto(id))
                    return new ResponseEntity(new Mensaje("No existe el Item buscado."), HttpStatus.NOT_FOUND);
                Proyecto proy = proService.buscarProyecto(id);
                return new ResponseEntity(proy, HttpStatus.OK);
            }
    
    @PreAuthorize("hasRole('ADMIN')")
        @PostMapping("/proyecto")
        public ResponseEntity<?> create(@RequestBody DTOProyecto pro){
            Proyecto proyectNuevo = new Proyecto( pro.getNombreProyecto(), pro.getDescripcion(), pro.getUrl_proyecto());
            proService.crearProyecto(proyectNuevo);
            return new ResponseEntity(new Mensaje("Proyecto Item creado."), HttpStatus.OK);
        }

     @PreAuthorize("hasRole('ADMIN')")
        @DeleteMapping("/proyecto/{id}")
        public ResponseEntity<?> delete(@PathVariable("id")Long id){
            if(!proService.existsProyecto(id))
                return new ResponseEntity(new Mensaje("No existe el Item buscado."), HttpStatus.NOT_FOUND);
            proService.borrarProyecto(id);
            return new ResponseEntity(new Mensaje("Item Proyecto eliminado."), HttpStatus.OK);
        }

    @PreAuthorize("hasRole('ADMIN')")
        @PutMapping("/proyecto/{id}")
        public ResponseEntity<?> update(@PathVariable("id")Long id, @RequestBody DTOProyecto proyDto){
            if(!proService.existsProyecto(id))
                return new ResponseEntity(new Mensaje("No existe el item buscado."), HttpStatus.NOT_FOUND);
            if(StringUtils.isBlank(proyDto.getNombreProyecto()))
                return new ResponseEntity(new Mensaje("Ingresar el nombre es obligatorio."), HttpStatus.BAD_REQUEST);
            if(StringUtils.isBlank(proyDto.getDescripcion()))
                return new ResponseEntity(new Mensaje("Ingresar la descripcion es obligatorio."), HttpStatus.BAD_REQUEST);
            if(StringUtils.isBlank(proyDto.getUrl_proyecto()))
                return new ResponseEntity(new Mensaje("Ingresar la url es obligatorio."), HttpStatus.BAD_REQUEST);
            

            Proyecto editPro = proService.buscarProyecto(id);
            editPro.setNombreProyecto(proyDto.getNombreProyecto());
            editPro.setDescripcion(proyDto.getDescripcion());
            editPro.setUrl_proyecto(proyDto.getUrl_proyecto());
            proService.crearProyecto(editPro);
            return new ResponseEntity(new Mensaje("Item Proyecto actualizado."), HttpStatus.OK);
        }


}
