package com.veterinaria.spring.veterinaria.repository;

import com.veterinaria.spring.veterinaria.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository          // opcional; aclara la intención
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    // Buscar por DNI (Spring Data implementa el query automáticamente)
    Cliente findByDni(String dni);
}
