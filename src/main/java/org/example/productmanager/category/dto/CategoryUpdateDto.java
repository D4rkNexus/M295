package org.example.productmanager.category.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "DTO für das Aktualisieren einer Kategorie")
public class CategoryUpdateDto {
    @Schema(description = "Name der Kategorie", example = "Updated Electronics")
    private String name;
}