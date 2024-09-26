package org.example.productmanager.category;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.productmanager.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "CategoryController", description = "Controller für Kategorien")
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Neue Kategorie erstellen (POST /categories)
    @PostMapping("/create")
    @Operation(summary = "Erstellt eine neue Kategorie", operationId = "createCategory", description = "Erstellt eine neue Kategorie basierend auf den bereitgestellten Informationen.")
    public ProductDetailDto createCategory(@RequestBody ProductCreateDto productCreateDto) {
        return categoryService.createCategory(productCreateDto);
    }

    // Kategorie nach ID anzeigen (GET /categories/{id})
    @GetMapping("/{id}")
    @Operation(summary = "Zeigt eine Kategorie mittels ID", operationId = "getCategoryById", description = "Gibt die Details einer Kategorie mit einer spezifischen ID zurück.")
    public ProductDetailDto getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    // Kategorie aktualisieren (PUT /categories/{id})
    @PutMapping("/{id}")
    @Operation(summary = "Aktualisiert mittels ID die Kategorie", operationId = "updateCategory", description = "Aktualisiert die Informationen einer Kategorie mit einer spezifischen ID.")
    public ProductDetailDto updateCategory(@PathVariable Long id, @RequestBody ProductUpdateDto productUpdateDto) {
        return categoryService.updateCategory(id, productUpdateDto);
    }

    // Kategorie löschen (DELETE /categories/{id})
    @DeleteMapping("/{id}")
    @Operation(summary = "Löscht mittels ID eine Kategorie", operationId = "deleteCategory", description = "Löscht eine Kategorie mit einer spezifischen ID.")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }

    // Alle Kategorien auflisten (GET /categories)
    @GetMapping("/list")
    @Operation(summary = "Listet alle Kategorien auf", operationId = "getAllCategories", description = "Listet alle vorhandenen Kategorien auf.")
    public List<ProductDetailDto> getAllCategories() {
        return categoryService.getAllCategories();
    }

    // Alle Produkte einer Kategorie auflisten (GET /categories/{id}/products)
    @GetMapping("/{id}/products")
    @Operation(summary = "Listet alle Produkte in einer Kategorie auf", operationId = "getProductsByCategory", description = "Listet alle Produkte auf, die einer spezifischen Kategorie zugeordnet sind.")
    public List<ProductShowDto> getProductsByCategory(@PathVariable Long id) {
        return categoryService.getProductsByCategory(id);
    }
}