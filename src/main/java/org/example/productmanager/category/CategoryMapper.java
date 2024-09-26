package org.example.productmanager.category;

import org.example.productmanager.category.CategoryData;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public abstract class CategoryMapper {

    // Mapping zum Erstellen einer neuen Kategorie
    public abstract CategoryData toEntity(String categoryName);

    // Mapping für das Aktualisieren einer Kategorie
    public abstract void update(String categoryName, @MappingTarget CategoryData category);
}