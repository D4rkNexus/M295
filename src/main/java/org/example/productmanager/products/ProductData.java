package org.example.productmanager.products;

import jakarta.persistence.*;
import org.example.productmanager.category.CategoryData;

@Entity
public class ProductData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "varchar(255)")
    private String sku;

    private boolean active;

    @Column(columnDefinition = "varchar(255)")
    private String name;

    @Column(length = 1000)
    private String image;

    @Lob
    private String description;

    private float price;

    private int stock;

    @ManyToOne
    private CategoryData category;

    public Long getId() {
        return id;
    }

    public String getSku() {
        return sku;
    }

    public boolean isActive() {
        return active;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setCategory(CategoryData category) {
        this.category = category;
    }

    public CategoryData getCategory() {
        return category;


    }
}
