package org.example.productmanager.user.security;

import lombok.Data;
import org.example.productmanager.user.UserData;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
public class MyUserPrincipal implements UserDetails {
    private UserData user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }

    public void setEmail(String email) {
        // Implementation here
    }

    public MyUserPrincipal(UserData user) {
        this.user = user;
    }

    // Other required methods from UserDetails should be implemented here (e.g., getPassword(), getUsername(), etc.)
}
