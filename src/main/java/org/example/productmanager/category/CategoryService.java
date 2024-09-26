package org.example.productmanager.category;

import org.example.productmanager.products.ProductData;
import org.example.productmanager.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    public CategoryData createCategory(CategoryData category) {
        return categoryRepository.save(category);
    }

    public CategoryData getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category with id " + id + " not found"));
    }

    public CategoryData updateCategory(Long id, CategoryData updatedCategory) {
        CategoryData existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category with id " + id + " not found"));

        existingCategory.setName(updatedCategory.getName());

        return categoryRepository.save(existingCategory);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    public List<CategoryData> getAllCategories() {
        return categoryRepository.findAll();
    }

    public List<ProductData> getProductsByCategory(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .map(category -> productRepository.findByCategory(category.getId()))
                .orElseThrow(() -> new RuntimeException("Category with id " + categoryId + " not found"));
    }
}