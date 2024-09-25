package org.example.productmanager.user;

import org.example.productmanager.dto.ProductShowDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class UserMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "todo", target = "todo")
    ProductShowDto toUserDataDto(UserData userData) {
        return null;
    }

}