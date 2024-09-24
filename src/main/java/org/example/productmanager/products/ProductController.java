package org.example.productmanager.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;


@RestController
@RequestMapping("products")
// http://localhost:8080/products
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("repository1")
    public List<ProductData> getAllProducts () {
        return productRepository.findAll();

    }

    @PostMapping
    public ProductData createProduct(@RequestBody ProductData product) {
        return productRepository.save(product);
    }

}

