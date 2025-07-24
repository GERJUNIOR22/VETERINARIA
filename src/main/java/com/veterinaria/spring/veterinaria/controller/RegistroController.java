package com.veterinaria.spring.veterinaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.veterinaria.spring.veterinaria.model.Usuario;

@Controller
public class RegistroController {

    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro"; // Va a buscar registro.html en templates
    }

    @PostMapping("/registro")
    public String procesarRegistro(@ModelAttribute Usuario usuario) {
        // Aquí deberías guardar el usuario en la BD (si quieres hacerlo)
        System.out.println("Registrado: " + usuario.getUsername());
        return "redirect:/login"; // Redirige a login.html al terminar
    }
}
