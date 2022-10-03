package com.argproyecto.demo.repository;

import com.argproyecto.demo.model.Intereses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteresesRepository extends JpaRepository <Intereses, Long>{
    
}
