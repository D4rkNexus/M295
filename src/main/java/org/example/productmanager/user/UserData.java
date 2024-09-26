package org.example.productmanager.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String username;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String password;

    @Column(columnDefinition = "tinyint", nullable = false)
    private Boolean isAdmin;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String email;

    @Column(columnDefinition = "VARCHAR(255)")
    private String role;

    public List<String> getRoles() {
        if(isAdmin) {
            return new ArrayList<>(){{
                add("ROLE_ADMIN");
            }};
        } else {
            return new ArrayList<>();
        }
    }
}