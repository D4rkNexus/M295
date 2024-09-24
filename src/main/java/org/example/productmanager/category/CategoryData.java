package org.example.productmanager.category;

import jakarta.persistence.*;
import org.example.productmanager.products.ProductData;

import java.util.List;

@Entity
public class CategoryData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private boolean active;

    @Column(columnDefinition = "varchar(255)")
    private String name;

    // Eine Kategorie kann mehrere Produkte haben
    @OneToMany(mappedBy = "category")
    private List<ProductData> products;

    public Long getId() {
        return id;
    }

    public boolean isActive() {
        return active;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProducts(List<ProductData> products) {
        this.products = products;
    }

    public List<ProductData> getProducts() {
        return products;



    }
}
