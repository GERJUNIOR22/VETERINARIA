package com.veterinaria.spring.veterinaria.repository;

import com.veterinaria.spring.veterinaria.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository            // opcional, pero aclara la intención
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    // Spring Data implementará este método automáticamente
    Usuario findByUsername(String username);
}
