package org.example.productmanager.category;

import org.example.productmanager.category.dto.CategoryCreateDto;
import org.example.productmanager.category.dto.CategoryUpdateDto;
import org.example.productmanager.products.dto.ProductDetailDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public abstract class CategoryMapper {

    // Mapping zum Erstellen einer neuen Kategorie
    @Mapping(target = "id", ignore = true)
    public abstract CategoryData fromCreateDto(CategoryCreateDto categoryCreateDto);

    // Mapping für das Anzeigen der Kategorie-Details (Detail)
    public abstract ProductDetailDto toDetailDto(CategoryData category);

    // Mapping für das Aktualisieren einer Kategorie
    public abstract void updateFromDto(CategoryUpdateDto categoryUpdateDto, @MappingTarget CategoryData category);

}
