// ProductShowDto.java
package org.example.productmanager.dto;

import lombok.Data;

@Data
public class ProductShowDto {
    private Long id;
    private String name;
    private Double price;
}