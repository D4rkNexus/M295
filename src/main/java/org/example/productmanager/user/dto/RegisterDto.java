package org.example.productmanager.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegisterDto {

    @NotNull
    @Schema (description = "Das Email eines Users")
    private String email;
    @NotNull
    @Schema (description = "Passwort eines Users oder neues Passwort")
    private String password;
    @NotNull
    @Schema (description = "isAdmin aktiviert oder nicht")
    private Boolean isAdmin;
}
