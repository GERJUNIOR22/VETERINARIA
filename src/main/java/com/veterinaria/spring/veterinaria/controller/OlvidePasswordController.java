package com.veterinaria.spring.veterinaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OlvidePasswordController {

    @GetMapping("/olvide-password")
    public String mostrarFormulario() {
        return "public/olvide-password";
    }

    @PostMapping("/olvide-password")
    public String procesarFormulario(@RequestParam String username, Model model) {
        model.addAttribute("mensaje", "Si el usuario existe, se enviará un correo de recuperación.");
        return "public/olvide-password";
    }
}
