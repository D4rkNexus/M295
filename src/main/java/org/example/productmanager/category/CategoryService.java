package org.example.productmanager.category;

import org.example.productmanager.products.ProductRepository;
import org.example.productmanager.products.ProductMapper;
import org.example.productmanager.products.dto.ProductDetailDto;
import org.example.productmanager.products.dto.ProductShowDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    public ProductDetailDto createCategory(ProductDetailDto productCreateDto) {
        CategoryData category = categoryMapper.fromCreateDto(productCreateDto);
        return categoryMapper.toDetailDto(categoryRepository.save(category));
    }

    public ProductDetailDto getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .map(categoryMapper::toDetailDto)
                .orElseThrow(() -> new RuntimeException("Category with id " + id + " not found"));
    }

    public ProductDetailDto updateCategory(Long id, ProductDetailDto productUpdateDto) {
        CategoryData existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category with id " + id + " not found"));

        categoryMapper.updateFromDto(productUpdateDto, existingCategory);
        return categoryMapper.toDetailDto(categoryRepository.save(existingCategory));
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    public List<ProductDetailDto> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::toDetailDto)
                .collect(Collectors.toList());
    }

    public List<ProductShowDto> getProductsByCategory(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .map(category -> productRepository.findByCategory(category.getId()).stream()
                        .map(productMapper::toShowDto)
                        .collect(Collectors.toList()))
                .orElseThrow(() -> new RuntimeException("Category with id " + categoryId + " not found"));
    }
}