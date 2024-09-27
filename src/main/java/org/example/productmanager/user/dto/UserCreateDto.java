package org.example.productmanager.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "DTO zum Erstellen eines neuen Benutzers")
public class UserCreateDto {
    @Schema(description = "Benutzername", example = "newuser")
    private String username;

    @Schema(description = "E-Mail des Benutzers", example = "newuser@example.com")
    private String email;

    @Schema(description = "Passwort des Benutzers", example = "securepassword")
    private String password;

    @Schema(description = "Rolle des Benutzers", example = "USER")
    private String role;
}