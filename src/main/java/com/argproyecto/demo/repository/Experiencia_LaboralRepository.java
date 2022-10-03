package com.argproyecto.demo.repository;

import com.argproyecto.demo.model.Experiencia_Laboral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Experiencia_LaboralRepository extends JpaRepository <Experiencia_Laboral, Long>{
    
}
