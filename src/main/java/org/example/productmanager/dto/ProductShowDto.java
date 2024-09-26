package org.example.productmanager.dto;

import lombok.Data;

import jakarta.validation.constraints.NotNull;

@Data
public class ProductShowDto {
    @NotNull
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Double price;

    private Long createdByUserId;

}