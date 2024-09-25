package org.example.productmanager.category;

import jdk.jfr.Category;
import org.mapstruct.Mapping;

public abstract class CategoryMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "price", target = "price")
public abstract CategoryData toData(Category category);
}
