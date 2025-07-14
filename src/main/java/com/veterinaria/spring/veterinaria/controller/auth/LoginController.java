package com.veterinaria.spring.veterinaria.controller.auth;

import com.veterinaria.spring.veterinaria.model.Usuario;
import com.veterinaria.spring.veterinaria.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/login")
    public String mostrarLogin() {
        return "public/login";
    }

    @GetMapping("/registro")
    public String mostrarRegistro() {
        return "public/registro";
    }

    @PostMapping("/registro")
    public String procesarRegistro(@RequestParam String nombreCompleto,
                                   @RequestParam String username,
                                   @RequestParam String password,
                                   @RequestParam String rol,
                                   Model model) {
        if (usuarioRepository.findByUsername(username) != null) {
            model.addAttribute("error", "El nombre de usuario ya existe");
            return "public/registro";
        }

        Usuario usuario = new Usuario();
        usuario.setNombreCompleto(nombreCompleto);
        usuario.setUsername(username);
        usuario.setPassword(password); // No encriptado por ahora
        usuario.setRol(rol);
        usuario.setEstado(Usuario.EstadoUsuario.ACTIVO);

        usuarioRepository.save(usuario);

        return "redirect:/login";
    }
}
