package com.example.bddruka.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration//Indicándole a Spring que tome en cuenta esta clase para la configuración de seguridad
@EnableWebSecurity//Permite activar la seguridad para las rutas que vamos a indicar
public class SecurityConfig {

    //Método para la encriptación de contraseña
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http//Especificamos las rutas a las que se puede acceder y a las que no o que se necesita un rol específico
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((requests -> requests
                        .requestMatchers("/plato", "/api", "/salon","/producto","/comensal/**","/categoriaproducto","/categoriaproducto/**").permitAll()
                        .requestMatchers("/reserva/lista","/categoriaplato","/categoriaplato/**").hasAuthority("ADMIN")
                        .anyRequest().permitAll()))
                .formLogin(login -> login
                        .loginPage("/login")
                        .defaultSuccessUrl("/hello"))
                .logout(logout -> logout
                        .permitAll());
        return http.build();
    }
}
