package org.example.productmanager.user.security;

import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.productmanager.user.TokenService;
import org.example.productmanager.user.UserData;
import org.example.productmanager.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * Filter, der sicherstellt, dass jede eingehende Anfrage ein gültiges JWT-Token enthält.
 * Überprüft das Token, extrahiert die Nutzerinformationen und setzt die Authentifizierung im
 * SecurityContextHolder, wenn das Token gültig ist.
 */
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    /**
     * Diese Methode wird für jede eingehende HTTP-Anfrage aufgerufen.
     * Sie überprüft den Autorisierungs-Header auf ein JWT-Token, validiert dieses
     * und authentifiziert den Benutzer, falls das Token gültig ist.
     *
     * @param request  Das HttpServletRequest-Objekt, das die Client-Anfrage darstellt
     * @param response Das HttpServletResponse-Objekt, das die Antwort des Servers repräsentiert
     * @param chain    Ein FilterChain, das genutzt wird, um den nächsten Filter aufzurufen
     *
     * @throws ServletException Wenn die Filterkette eine Exception auslöst
     * @throws IOException      Wenn ein Ein-/Ausgabefehler auftritt
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {

        // Holt den Autorisierungs-Header vom eingehenden Request
        final String authorizationHeader = request.getHeader("Authorization");

        String email = null;
        String jwt = null;

        // Überprüft, ob der Autorisierungs-Header den JWT-Token enthält und extrahiert diesen
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
            email = Jwts.parser()
                    .setSigningKey(tokenService.getSecretKey())
                    .parseClaimsJws(jwt)
                    .getBody()
                    .getSubject();
        }

        // Wenn die E-Mail extrahiert wurde und der Benutzer noch nicht authentifiziert ist, authentifiziert ihn
        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            try {
                UserData user = userService.findUserByEmail(email);
                MyUserPrincipal userPrincipal = new MyUserPrincipal(user);
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(userPrincipal, null, userPrincipal.getAuthorities());

                // Setzt die Authentifizierung im SecurityContextHolder
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                System.out.println("User authenticated: " + email);
            } catch (Exception e) {
                System.err.println("Authentication error: " + e.getMessage());
            }
        }

        // Setzt die Filterkette fort und lässt die Anfrage weiter durch den Filter gelangen
        chain.doFilter(request, response);
    }
}