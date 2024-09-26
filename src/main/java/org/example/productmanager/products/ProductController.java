package org.example.productmanager.products;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.productmanager.dto.*;
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
    public ProductShowDto createProduct(@RequestBody ProductCreateDto productCreateDto) {
        return productService.createProduct(productCreateDto);
    }

    // Produkt nach ID anzeigen (GET /products/{id})
    @GetMapping("/{id}")
    @Operation(summary = "Produkt mittels ID anzeigen")
    public ProductDetailDto getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    // Produkt aktualisieren (PUT /products/{id})
    @PutMapping("/{id}")
    @Operation(summary = "Produkt mittels ID aktualisieren")
    public ProductShowDto updateProduct(@PathVariable Long id, @RequestBody ProductUpdateDto productUpdateDto) {
        return productService.updateProduct(id, productUpdateDto);
    }

    // Produkt löschen (DELETE /products/{id})
    @DeleteMapping("/{id}")
    @Operation(summary = "Produkt mittels ID löschen")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    // Alle Produkte auflisten (GET /products)
    @GetMapping
    @Operation(summary = "Alle Produkte auflisten")
    public List<ProductShowDto> getAllProducts() {
        return productService.getAllProducts();
    }
}