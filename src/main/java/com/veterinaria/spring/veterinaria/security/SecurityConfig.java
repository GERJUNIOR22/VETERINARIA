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
            .userDetailsService(userDetailsService)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/",                // Página principal
                    "/login",          // Login
                    "/adopta",         // Página de adopción
                    "/registro",       // Registro
                    "/public/**",      // Archivos estáticos
                    "/admin/**"
                ).permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(login -> login
                .loginPage("/login")               // Página personalizada
                .loginProcessingUrl("/login")      // POST que procesa Spring
                .defaultSuccessUrl("/", true)      // ✅ Redirigir a página principal
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

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance(); // Solo para desarrollo
    }
}
