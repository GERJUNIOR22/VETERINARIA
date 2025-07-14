package com.veterinaria.spring.veterinaria.repository;

import com.veterinaria.spring.veterinaria.model.Albergue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AlbergueRepository extends JpaRepository<Albergue, Integer> {

    // Buscar albergues cuyo nombre contenga cierta palabra
    List<Albergue> findByNombreContainingIgnoreCase(String nombre);
}
