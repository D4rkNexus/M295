package org.example.productmanager.products;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.productmanager.category.CategoryData;

@Entity
@Getter
@Setter
@Schema(description = "Product Schema")
public class ProductData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String sku;

    @Column(columnDefinition = "TINYINT", nullable = false)
    private boolean active;

    @Column(columnDefinition = "VARCHAR(500)", nullable = false)
    private String name;

    @Column(columnDefinition = "VARCHAR(1000)")
    private String image;

    @Column(columnDefinition = "MEDIUMTEXT")
    private String description;

    @Column(columnDefinition = "FLOAT", nullable = false)
    private float price;

    @Column(columnDefinition = "INT", nullable = false)
    private int stock;

    @ManyToOne
    @JoinColumn(name = "category_Id", nullable = false)
    private CategoryData category;
}