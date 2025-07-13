package com.veterinaria.spring.veterinaria.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "¡Hola este es nuestro primer proyecto gurpal con Spring Boot!";
    }
}
