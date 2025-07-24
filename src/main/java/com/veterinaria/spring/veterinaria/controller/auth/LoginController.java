package com.veterinaria.spring.veterinaria.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.veterinaria.spring.veterinaria.model.Usuario;
import com.veterinaria.spring.veterinaria.repository.UsuarioRepository;

@Controller
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/login")
    public String mostrarLogin() {
        return "public/login";
    }

    // ✅ Cambiado para evitar conflicto con RegistroController
    @GetMapping("/registro-desde-login")
    public String mostrarRegistroDesdeLogin() {
        return "public/registro"; // o "registro" si es tu nombre de vista
    }

    // ✅ También cambiamos la ruta POST para evitar duplicado con RegistroController
    @PostMapping("/registro-desde-login")
    public String procesarRegistroDesdeLogin(@RequestParam String nombreCompleto,
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
