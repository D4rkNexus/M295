package org.example.productmanager.category;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.productmanager.category.dto.CategoryCreateDto;
import org.example.productmanager.category.dto.CategoryUpdateDto;
import org.example.productmanager.products.dto.ProductDetailDto;
import org.example.productmanager.products.dto.ProductShowDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "CategoryController", description = "Controller für Kategorien")
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    @Operation(summary = "Erstellt eine neue Kategorie", operationId = "createCategory", description = "Erstellt eine neue Kategorie basierend auf den bereitgestellten Informationen.")
    public ProductDetailDto createCategory(@RequestBody CategoryCreateDto categoryCreateDto) {
        return categoryService.createCategory(categoryCreateDto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Zeigt eine Kategorie mittels ID", operationId = "getCategoryById", description = "Gibt die Details einer Kategorie mit einer spezifischen ID zurück.")
    public ProductDetailDto getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Aktualisiert eine Kategorie mittels ID", operationId = "updateCategory", description = "Aktualisiert die Informationen einer Kategorie mit einer spezifischen ID.")
    public ProductDetailDto updateCategory(@PathVariable Long id, @RequestBody CategoryUpdateDto categoryUpdateDto) {
        return categoryService.updateCategory(id, categoryUpdateDto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Löscht mittels ID eine Kategorie", operationId = "deleteCategory", description = "Löscht eine Kategorie mit einer spezifischen ID.")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }

    @GetMapping("/list")
    @Operation(summary = "Listet alle Kategorien auf", operationId = "getAllCategories", description = "Listet alle vorhandenen Kategorien auf.")
    public List<ProductDetailDto> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}/products")
    @Operation(summary = "Listet alle Produkte in einer Kategorie auf", operationId = "getProductsByCategory", description = "Listet alle Produkte auf, die einer spezifischen Kategorie zugeordnet sind.")
    public List<ProductShowDto> getProductsByCategory(@PathVariable Long id) {
        return categoryService.getProductsByCategory(id);
    }
}