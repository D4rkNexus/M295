package org.example.productmanager.products;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.productmanager.products.dto.ProductCreateDto;
import org.example.productmanager.products.dto.ProductDetailDto;
import org.example.productmanager.products.dto.ProductShowDto;
import org.example.productmanager.products.dto.ProductUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "ProductController", description = "Controller für Produkte")
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Neues Produkt erstellen (POST /products)
    @PostMapping
    @Operation(summary = "Neues Produkt erstellen", operationId = "createProduct", description = "Erstellt ein neues Produkt basierend auf den bereitgestellten Informationen.")
    public ProductShowDto createProduct(@RequestBody ProductCreateDto productCreateDto) {
        return productService.createProduct(productCreateDto);
    }

    // Produkt nach ID anzeigen (GET /products/{id})
    @GetMapping("/{id}")
    @Operation(summary = "Produkt mittels ID anzeigen", operationId = "getProductById", description = "Gibt die Details eines Produkts mit einer spezifischen ID zurück.")
    public ProductDetailDto getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    // Produkt aktualisieren (PUT /products/{id})
    @PutMapping("/{id}")
    @Operation(summary = "Produkt mittels ID aktualisieren", operationId = "updateProduct", description = "Aktualisiert die Informationen eines Produkts mit einer spezifischen ID.")
    public ProductShowDto updateProduct(@PathVariable Long id, @RequestBody ProductUpdateDto productUpdateDto) {
        return productService.updateProduct(id, productUpdateDto);
    }

    // Produkt löschen (DELETE /products/{id})
    @DeleteMapping("/{id}")
    @Operation(summary = "Produkt mittels ID löschen", operationId = "deleteProduct", description = "Löscht ein Produkt mit einer spezifischen ID.")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    // Alle Produkte auflisten (GET /products)
    @GetMapping
    @Operation(summary = "Alle Produkte auflisten", operationId = "getAllProducts", description = "Listet alle vorhandenen Produkte auf.")
    public List<ProductShowDto> getAllProducts() {
        return productService.getAllProducts();
    }
}