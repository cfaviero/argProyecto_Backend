package com.argproyecto.demo.repository;

import com.argproyecto.demo.model.AcercaDe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AcercaDeRepository extends JpaRepository <AcercaDe, Long>{
    
}
