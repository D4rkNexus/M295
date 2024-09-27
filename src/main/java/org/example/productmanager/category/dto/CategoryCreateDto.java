package org.example.productmanager.category.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "DTO für das Erstellen einer neuen Kategorie")
public class CategoryCreateDto {
    @Schema(description = "Name der Kategorie", example = "Electronics")
    private String name;
}