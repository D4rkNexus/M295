package org.example.productmanager.user.dto;

import lombok.Data;

@Data
public class RegisterDto {
    private String email;
    private String password;
    private Boolean isAdmin;
}
