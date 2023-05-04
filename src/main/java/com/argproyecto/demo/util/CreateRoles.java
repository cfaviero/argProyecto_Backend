package com.argproyecto.demo.util;

import com.argproyecto.demo.security.entity.Rol;
import com.argproyecto.demo.security.enums.RolNombre;
import com.argproyecto.demo.security.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CreateRoles implements CommandLineRunner{
    
    @Autowired
    RolService RolService;
    
    @Override
    public void run(String... args) throws Exception {
        Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
        Rol rolUser = new Rol(RolNombre.ROLE_USER);
        RolService.save(rolAdmin);
        RolService.save(rolUser);
    }
    
    
    
} //******SE EJECUTA SOLO UNA VEZ PARA CREAR LOS ROLES EN LA BASE DE DATOS
