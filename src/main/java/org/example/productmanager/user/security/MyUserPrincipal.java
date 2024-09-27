package org.example.productmanager.user.security;

import lombok.Data;
import org.example.productmanager.user.UserData;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Schema(description = "Repräsentiert den benutzerdefinierten UserPrincipal für die Authentifizierung und Autorisierung")
public class MyUserPrincipal implements UserDetails {
    @Schema(description = "Benutzerdaten des authentifizierten Benutzers")
    private UserData user;

    public MyUserPrincipal(UserData user) {
        this.user = user;
    }

    @Override
    @Schema(description = "Gibt die Autoritäten/Rollen des Benutzers zurück")
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }

    @Override
    @Schema(description = "Gibt das Passwort des Benutzers zurück", example = "password123")
    public String getPassword() {
        return ""; // Hier können tatsächliche Passwort-Felder zurückgegeben werden
    }

    @Override
    @Schema(description = "Gibt den Benutzernamen zurück", example = "username")
    public String getUsername() {
        return ""; // Hier können tatsächliche Benutzername-Felder zurückgegeben werden
    }

    @Schema(description = "Setzt die E-Mail des Benutzers", example = "user@example.com")
    public void setEmail(String email) {
        // Implementierung hier
    }
}