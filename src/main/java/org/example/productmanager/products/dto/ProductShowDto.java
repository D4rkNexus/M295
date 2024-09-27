package org.example.productmanager.products.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;

@Data
@Schema (description = "ProductShowDto Schema")
public class ProductShowDto {

    @NotNull
    @Schema(description = "Einzigartige Identifikationsnummer des Produkts", example = "1")
    private Long id;

    @NotNull
    @Schema(description = "Name des Produkts", example = "Laptop")
    private String name;

    @NotNull
    @Schema(description = "Preis des Produkts", example = "999.99")
    private Double price;

    @Schema(description = "ID des Benutzers, der das Produkt erstellt hat", example = "10")
    private Long createdByUserId;
    }

