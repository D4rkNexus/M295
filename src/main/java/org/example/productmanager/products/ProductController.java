package org.example.productmanager.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("products")
// http://localhost:8080/products
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("repository1")
    public List<ProductData> getAllProducts () {
        return productService.getAllProducts();

    }

    @PostMapping
    public ProductData createProduct(@RequestBody ProductData product) {
        return productService.save(product);
    }

}

