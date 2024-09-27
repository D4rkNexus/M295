package org.example.productmanager.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import jakarta.validation.constraints.NotNull;

@Data
@Schema(description = "Schema für Login-Anfragen")
public class LoginRequestDto {


    public String getEmail;
    @NotNull
    @Schema(description = "E-Mail oder Benutzername des Benutzers", example = "user@example.com", required = true)
    private String email;

    @NotNull
    @Schema(description = "Passwort des Benutzers", example = "securePassword123", required = true)
    private String password;
}