package org.example.productmanager.user.security;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Wrapper für JWT-Token")
public class TokenWrapper {
    @Schema(description = "JWT-Token", example = "eyJhbGciOiJIUzI1...")
    private String token;

}