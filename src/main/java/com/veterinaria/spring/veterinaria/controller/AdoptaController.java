package com.veterinaria.spring.veterinaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adopta")
public class AdoptaController {

    @GetMapping
    public String mostrarAdopta() {
        return "public/adopta";
    }
}