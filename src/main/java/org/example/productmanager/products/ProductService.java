package org.example.productmanager.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Alle Produkte auflisten
    public List<ProductData> getAllProducts() {
        return productRepository.findAll();
    }

    // Neues Produkt erstellen
    public ProductData createProduct(ProductData product) {
        return productRepository.save(product);
    }

    // Produkt nach ID anzeigen
    public ProductData getProductById(Long id) {
        Optional<ProductData> product = productRepository.findById(id);
        return product.orElse(null);
    }

    // Produkt aktualisieren
    public ProductData updateProduct(Long id, ProductData product) {
        if (productRepository.existsById(id)) {
            product.setId(id);  // Sicherstellen, dass die ID im Produkt gesetzt ist
            return productRepository.save(product);
        } else {
            return null;
        }
    }

    // Produkt löschen
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}