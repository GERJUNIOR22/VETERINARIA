package com.veterinaria.spring.veterinaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Al visitar "/", se muestra public/index.html
    @GetMapping("/")
    public String mostrarInicio() {
        return "public/index"; // Thymeleaf buscará templates/public/index.html
    }
}