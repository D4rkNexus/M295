package org.example.productmanager.dto;

import lombok.Data;

import jakarta.validation.constraints.NotNull;

@Data
public class ProductDetailDto {
    @NotNull
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Double price;

    @NotNull
    private String description;

    private Long createdByUserId;
}