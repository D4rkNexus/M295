package org.example.productmanager.products;

import org.example.productmanager.dto.ProductShowDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class ProductMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "categoryId", target = "categoryId")
    public abstract ProductShowDto toProductDto(ProductShowDto product); // Eine Methode zum Mappen eines Objekts zu einem anderen

}