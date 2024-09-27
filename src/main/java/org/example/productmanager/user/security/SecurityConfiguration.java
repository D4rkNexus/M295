package org.example.productmanager.user.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfiguration {
    @Autowired
    private JwtRequestFilter jwtRequestFilter;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        http
                .httpBasic().disable()
                .authorizeHttpRequests((authz) -> authz.requestMatchers("/users/authenticate").permitAll()
                        .requestMatchers("/swagger-ui/index.html").permitAll()
                        .requestMatchers("/swagger-ui/*").permitAll()
                        .requestMatchers("/v3/api-docs").permitAll()
                        .requestMatchers("/v3/api-docs/swagger-config").permitAll()
                        .anyRequest().authenticated()
                );
            return http.build();
    }
}