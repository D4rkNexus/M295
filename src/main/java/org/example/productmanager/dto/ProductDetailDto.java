// ProductDetailDto.java
package org.example.productmanager.dto;

import lombok.Data;

@Data
public class ProductDetailDto {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private String categoryName;
}