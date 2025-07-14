package com.veterinaria.spring.veterinaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Ruta de inicio
    @GetMapping("/")
    public String mostrarInicio() {
        return "public/index"; // templates/public/index.html
    }

    // Ruta para la sección Adopta
    @GetMapping("/adopta")
    public String mostrarAdopta() {
        return "public/adopta"; // templates/public/adopta.html
    }

    // Ruta para servicios (si luego lo haces)
    @GetMapping("/servicios")
    public String mostrarServicios() {
        return "public/servicios"; // templates/public/servicios.html
    }

    // Ruta para contacto
    @GetMapping("/contacto")
    public String mostrarContacto() {
        return "public/contacto"; // templates/public/contacto.html
    }
}
