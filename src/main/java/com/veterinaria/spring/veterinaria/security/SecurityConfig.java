package com.veterinaria.spring.veterinaria.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/",                // Página principal
                    "/login",      // Login
                    "/adopta",      //Adopta perro
                    "/registro",        // Registro
                    "/public/**",       // Archivos CSS, js y img
                    "/admin/**"         // Archivos CSS, js y img
                ).permitAll() // Acceso sin login
                .anyRequest().authenticated() // El resto requiere login
            )
            .formLogin(login -> login
                .loginPage("/login") // Página de login
                .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/login?logout")
                .permitAll()
            );

        return http.build();
    }
}
