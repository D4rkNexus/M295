package org.example.productmanager.products;

import org.example.productmanager.dto.*;
import org.example.productmanager.products.ProductData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public abstract class ProductMapper {

    // Mapping für das Erstellen einer neuen Produktentität
    @Mapping(source = "name", target = "name")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "categoryId", target = "category.id")
    public abstract ProductData toEntity(ProductCreateDto productCreateDto);

    // Mapping für das Anzeigen eines Produkts (Show)
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "price", target = "price")
    public abstract ProductShowDto toShowDto(ProductData product);

    // Mapping für das Anzeigen der Produktdetails (Detail)
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "description", target = "description")
    public abstract ProductDetailDto toDetailDto(ProductData product);

    // Mapping für das Aktualisieren eines Produkts
    @Mapping(source = "name", target = "name")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "categoryId", target = "category.id")
    public abstract void update(ProductUpdateDto productUpdateDto, @MappingTarget ProductData product);
}