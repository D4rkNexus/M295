package org.example.productmanager.user.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import io.swagger.v3.oas.annotations.media.Schema;

@Configuration
@Schema(description = "Konfiguration der Sicherheitsfilter und Authentifizierungsregeln")
public class SecurityConfiguration {

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    /**
     * Konfiguriert die Sicherheitsfilterkette für HTTP-Anfragen.
     *
     * @param http Das HttpSecurity-Objekt zur Konfiguration der Sicherheitsfilter
     * @return Das konfigurierte SecurityFilterChain-Objekt
     * @throws Exception Falls bei der Konfiguration ein Fehler auftritt
     */
    @Bean
    @Schema(description = "Bean zur Konfiguration der HTTP-Sicherheitsfilterkette")
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Testweise CSRF deaktivieren
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/users/auth").permitAll()
                        .requestMatchers("/users/create").permitAll()
                        .requestMatchers("/users/register").permitAll()
                        .requestMatchers("/authenticate").permitAll()
                        .requestMatchers("/users/list").permitAll()
                        .requestMatchers("/swagger-ui/index.html").permitAll()
                        .requestMatchers("/swagger-ui/*").permitAll()
                        .requestMatchers("/swagger-ui").permitAll()
                        .requestMatchers("/v3/api-docs").permitAll()
                        .requestMatchers("/v3/api-docs/swagger-config").permitAll()
                        .anyRequest().authenticated()
                );
        return http.build();
    }
}