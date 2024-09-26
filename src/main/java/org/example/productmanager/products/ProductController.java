package org.example.productmanager.products;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.productmanager.dto.ProductShowDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "ProductController", description = "")
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Neues Produkt erstellen (POST /products)
    @PostMapping
    @Operation(summary = "Neues Produkt erstellen")
    public ProductData createProduct(@RequestBody ProductData product) {
        return productService.createProduct(product);
    }

    // Produkt nach ID anzeigen (GET /products/{id})
    @GetMapping("/{id}")
    @Operation (summary = "Produkte mittels ID anzeigen")
    public ProductData getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    // Produkt aktualisieren (PUT /products/{id})
    @PutMapping("/{id}")
    @Operation (summary = "Produkt mittels ID aktualisieren")
    public ProductData updateProduct(@PathVariable Long id, @RequestBody ProductData product) {
        return productService.updateProduct(id, product);
    }

    // Produkt löschen (DELETE /products/{id})
    @DeleteMapping("/{id}")
    @Operation (summary = "Produkt mittels ID löschen")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    // Alle Produkte auflisten (GET /products)
    @GetMapping("/Productlist")
    @Operation (summary = "Alle Produkte auflisten")
    public List<ProductShowDto> getAllProducts() {
        return productService.getAllProducts();
    }
}