package com.veterinaria.spring.veterinaria.repository;

import com.veterinaria.spring.veterinaria.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Integer> {

    // Buscar todas las mascotas con un estado concreto (Disponible, Adoptado…)
    List<Mascota> findByEstado(String estado);

    // Buscar por especie, ignorando mayúsculas/minúsculas
    List<Mascota> findByEspecieIgnoreCase(String especie);

    // Mascotas adoptadas por un cliente específico
    List<Mascota> findByClienteId(Integer clienteId);
}
