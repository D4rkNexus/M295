package org.example.productmanager.dto;

import lombok.Data;

import jakarta.validation.constraints.NotNull;

@Data
public class ProductUpdateDto {
    @NotNull
    private String name;

    @NotNull
    private Double price;

    @NotNull
    private String description;

    @NotNull
    private Long categoryId;

    private Long updatedByUserId;
}