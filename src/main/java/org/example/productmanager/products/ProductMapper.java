package org.example.productmanager.products;

import org.example.productmanager.products.dto.ProductCreateDto;
import org.example.productmanager.products.dto.ProductDetailDto;
import org.example.productmanager.products.dto.ProductShowDto;
import org.example.productmanager.products.dto.ProductUpdateDto;
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
    public abstract ProductData fromCreateDto(ProductCreateDto productCreateDto);

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
    public abstract void updateFromDto(ProductUpdateDto productUpdateDto, @MappingTarget ProductData product);
}