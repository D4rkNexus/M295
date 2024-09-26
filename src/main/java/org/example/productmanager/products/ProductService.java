package org.example.productmanager.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductData> getAllProducts() {
        return productRepository.findAll();
    }

    public ProductData createProduct(ProductData product) {
        return productRepository.save(product);
    }

    public ProductData getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product with id " + id + " not found"));
    }

    public ProductData updateProduct(Long id, ProductData updatedProduct) {
        ProductData existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product with id " + id + " not found"));

        existingProduct.setSku(updatedProduct.getSku());
        existingProduct.setActive(updatedProduct.isActive());
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setImage(updatedProduct.getImage());
        existingProduct.setDescription(updatedProduct.getDescription());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setStock(updatedProduct.getStock());
        existingProduct.setCategory(updatedProduct.getCategory());

        return productRepository.save(existingProduct);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}