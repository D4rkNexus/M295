// ProductCreateDto.java
package org.example.productmanager.dto;

import lombok.Data;

@Data
public class ProductCreateDto {
    private String name;
    private Double price;
    private String description;
    private Long categoryId;
}