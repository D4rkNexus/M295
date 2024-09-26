package org.example.productmanager.products;

import org.example.productmanager.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    public List<ProductShowDto> getAllProducts() {
        // Alle Produkte laden und in ProductShowDto-Objekte konvertieren
        return productRepository.findAll().stream()
                .map(productMapper::toShowDto)
                .collect(Collectors.toList());
    }

    public ProductShowDto createProduct(ProductCreateDto productCreateDto) {
        // Neues Produkt erstellen und als ProductShowDto zurückgeben
        ProductData product = productMapper.fromCreateDto(productCreateDto);
        return productMapper.toShowDto(productRepository.save(product));
    }

    public ProductDetailDto getProductById(Long id) {
        // Produkt nach ID suchen und als ProductDetailDto zurückgeben
        return productRepository.findById(id)
                .map(productMapper::toDetailDto)
                .orElseThrow(() -> new RuntimeException("Product with id " + id + " not found"));
    }

    public ProductShowDto updateProduct(Long id, ProductUpdateDto updatedProductDto) {
        // Produkt nach ID suchen und aktualisieren
        ProductData existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product with id " + id + " not found"));

        productMapper.updateFromDto(updatedProductDto, existingProduct);
        return productMapper.toShowDto(productRepository.save(existingProduct));
    }

    public void deleteProduct(Long id) {
        // Produkt nach ID löschen
        productRepository.deleteById(id);
    }
}