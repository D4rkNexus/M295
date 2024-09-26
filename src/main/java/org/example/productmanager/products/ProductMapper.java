package org.example.productmanager.products;

import org.example.productmanager.dto.ProductShowDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public abstract class ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "categoryId", target = "categoryId")
    ProductShowDto toProductDto(ProductData product) {
        return null;
    }

    List<ProductShowDto> toProductDtoList(List<ProductData> products) {
        return null;
    }

    @Mapping(source = "name", target = "name")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "categoryId", target = "categoryId")
    ProductData toProductData(ProductShowDto productDto) {
        return null;
    }
}