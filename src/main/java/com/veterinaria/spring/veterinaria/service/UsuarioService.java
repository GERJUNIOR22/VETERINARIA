package com.veterinaria.spring.veterinaria.service;

import com.veterinaria.spring.veterinaria.model.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    Usuario guardarUsuario(Usuario usuario);
    Optional<Usuario> obtenerUsuarioPorId(Integer id);
    Usuario obtenerPorUsername(String username);
    List<Usuario> listarUsuarios();
    void eliminarUsuario(Integer id);
}