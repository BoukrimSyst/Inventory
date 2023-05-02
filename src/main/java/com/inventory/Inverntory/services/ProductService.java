package com.inventory.Inverntory.services;

import com.inventory.Inverntory.models.Product;
import com.inventory.Inverntory.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findProductById(id);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public void removeProduct(Long id) {
        productRepository.deleteProductById(id);
    }

    public Optional<Product> updateProduct(Long id,Product product) {
        Optional<Product> existingProduct = productRepository.findProductById(id);
        if (existingProduct.isPresent()) {
            Product updatedProduct = existingProduct.get();
            updatedProduct.setName(product.getName());
            updatedProduct.setDescription(product.getDescription());
            updatedProduct.setPrice(product.getPrice());
            productRepository.save(updatedProduct);
        }
        return existingProduct;
    }
}



















