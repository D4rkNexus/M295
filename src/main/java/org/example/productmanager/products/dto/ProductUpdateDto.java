package org.example.productmanager.products.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
public class ProductUpdateDto {

    @NotNull
    @Schema(description = "Name des Produkts", example = "Laptop")
    private String name;

    @NotNull
    @Schema(description = "Preis des Produkts", example = "999.99")
    private Double price;

    @NotNull
    @Schema(description = "Beschreibung des Produkts", example = "Ein leistungsstarker Laptop")
    private String description;

    @NotNull
    @Schema(description = "ID der zugehörigen Kategorie", example = "2")
    private Long categoryId;

    @Schema(description = "ID des Benutzers, der das Produkt aktualisiert hat", example = "10")
    private Long updatedByUserId;
}