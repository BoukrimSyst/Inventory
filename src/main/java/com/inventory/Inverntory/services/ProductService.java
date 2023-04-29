package com.inventory.Inverntory.services;

import com.inventory.Inverntory.models.Product;
import com.inventory.Inverntory.repositories.ProductRepository;
import org.hibernate.sql.exec.spi.StandardEntityInstanceResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import static aj.org.objectweb.asm.TypePath.fromString;


@Service
public class ProductService {


    private final ProductRepository productRepository;


    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findByProductId(id)
                .orElseThrow(() -> new RuntimeException("Product by ID "+ id + "was not found !"));
    }

    public Product addProduct(Product product) {
        product.setId(UUID.randomUUID());
        return productRepository.save(product);
    }

    public void removeProduct(Long id) {
        productRepository.deleteProductById(id);
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }
}



















