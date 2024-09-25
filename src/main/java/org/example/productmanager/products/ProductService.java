package org.example.productmanager.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductData> getAllProducts() {
        return productRepository.findAll();
    }

    public ProductData save(ProductData product) {
        return productRepository.save(product);
    }
}
