package com.argproyecto.demo.repository;

import com.argproyecto.demo.model.Acerca_De;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Acerca_DeRepository extends JpaRepository <Acerca_De, Long>{
    
}
