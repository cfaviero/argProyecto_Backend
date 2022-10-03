package com.argproyecto.demo.repository;

import com.argproyecto.demo.model.Conocimientos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConocimientosRepository extends JpaRepository <Conocimientos, Long>{
    
    
    
}
