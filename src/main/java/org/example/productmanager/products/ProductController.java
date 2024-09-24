package org.example.productmanager.products;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("products")
// http://localhost:8080/products
public class ProductController {

    @GetMapping
    public String getAllProducts() {
        return "All products";
    }
}
