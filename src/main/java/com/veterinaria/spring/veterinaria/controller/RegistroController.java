package com.veterinaria.spring.veterinaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.veterinaria.spring.veterinaria.model.Usuario;
import com.veterinaria.spring.veterinaria.repository.UsuarioRepository;

@Controller
public class RegistroController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "public/registro";
    }

    @PostMapping("/registro")
    public String procesarRegistro(@ModelAttribute Usuario usuario) {
        usuario.setRol("USER"); // Asigna rol si es obligatorio
        usuario.setEstado(Usuario.EstadoUsuario.ACTIVO); // Asigna estado si es obligatorio
        usuarioRepository.save(usuario); // Guarda el usuario en la BD
        return "redirect:/login";
    }
}
