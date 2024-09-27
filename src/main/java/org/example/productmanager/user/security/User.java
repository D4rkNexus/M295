package org.example.productmanager.user.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String email;

    public List<String> getRoles() {
        List<String> hardcodedRoles = new ArrayList<>();
        hardcodedRoles.add("ROLE_ADMIN");
        return hardcodedRoles;
    }

    public String getUsername() {
        return null;
    }

    public String getPassword() {
        return null;
    }
}

