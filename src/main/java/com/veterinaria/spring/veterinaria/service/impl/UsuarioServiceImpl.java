package com.veterinaria.spring.veterinaria.service.impl;

import com.veterinaria.spring.veterinaria.model.Usuario;
import com.veterinaria.spring.veterinaria.repository.UsuarioRepository;
import com.veterinaria.spring.veterinaria.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> obtenerUsuarioPorId(Integer id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario obtenerPorUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public void eliminarUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
