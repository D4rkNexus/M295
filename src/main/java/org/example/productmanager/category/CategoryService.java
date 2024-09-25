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
        return categoryRepository.findById(id).orElse(null);
    }

    public CategoryData updateCategory(Long id, CategoryData updatedCategory) {
        return categoryRepository.findById(id)
                .map(category -> {
                    category.setName(updatedCategory.getName());
                    return categoryRepository.save(category);
                })
                .orElse(null);
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
                .orElse(null);
    }
}