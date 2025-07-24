package com.veterinaria.spring.veterinaria.security;

import com.veterinaria.spring.veterinaria.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .userDetailsService(userDetailsService) // REGISTRO DEL SERVICIO
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/",                // Página principal
                    "/login",          // Login
                    "/adopta",         // Página de adopción
                    "/registro",       // Registro
                    "/public/**",      // Archivos estáticos
                    "/admin/**"
                ).permitAll()
                .anyRequest().authenticated() // Todo lo demás requiere login
            )
            .formLogin(login -> login
                .loginPage("/login")               // Página personalizada
                .loginProcessingUrl("/login")      // POST que procesa Spring
                .defaultSuccessUrl("/dashboard", true) // Página post-login
                .failureUrl("/login?error=true")   // Si falla login
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout=true")
                .permitAll()
            );

        return http.build();
    }

    // PERMITIR TEXTO PLANO - SOLO PARA DESARROLLO
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
