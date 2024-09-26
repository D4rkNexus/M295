package org.example.productmanager.category;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.productmanager.products.ProductData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "CategoryController")
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Neue Kategorie erstellen (POST /categories)
    @PostMapping
    @Operation (summary = "Erstellt eine neue Kategorie")
    public CategoryData createCategory(@RequestBody CategoryData category) {
        return categoryService.createCategory(category);
    }

    // Kategorie nach ID anzeigen (GET /categories/{id})
    @GetMapping("/{id}")
    public CategoryData getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    // Kategorie aktualisieren (PUT /categories/{id})
    @PutMapping("/{id}")
    public CategoryData updateCategory(@PathVariable Long id, @RequestBody CategoryData category) {
        return categoryService.updateCategory(id, category);
    }

    // Kategorie löschen (DELETE /categories/{id})
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }

    // Alle Kategorien auflisten (GET /categories)
    @GetMapping
    public List<CategoryData> getAllCategories() {
        return categoryService.getAllCategories();
    }

    // Alle Produkte einer Kategorie auflisten (GET /categories/{id}/products)
    @GetMapping("/{id}/products")
    public List<ProductData> getProductsByCategory(@PathVariable Long id) {
        return categoryService.getProductsByCategory(id);
    }
}
