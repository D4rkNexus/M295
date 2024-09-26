package org.example.productmanager.products.dto;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Schema(description = "ProductCreateDTO Schema")
public class ProductCreateDto {

    @NotNull
    @Schema(description = "SKU des Produkts", example = "ABC123")
    private String sku;

    @NotNull
    @Schema(description = "Ob das Produkt aktiv ist", example = "true")
    private boolean active;

    @NotNull
    @Schema(description = "Name des Produkts", example = "Laptop")
    private String name;

    @NotNull
    @Schema(description = "Bild des Produkts", example = "http://example.com/image.jpg")
    private String image;

    @NotNull
    @Schema(description = "Beschreibung des Produkts", example = "Ein leistungsstarker Laptop")
    private String description;

    @NotNull
    @Schema(description = "Preis des Produkts", example = "999.99")
    private Float price;

    @NotNull
    @Schema(description = "Lagerbestand des Produkts", example = "50")
    private Integer stock;

    @NotNull
    @Schema(description = "ID der zugehörigen Kategorie", example = "2")
    private Long categoryId;

    public String getUsername() {
        return null;
    }

    public String getPassword() {
        return null;
    }
}
