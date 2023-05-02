package com.inventory.Inverntory.services;


import com.inventory.Inverntory.RandomStringGenerator;
import com.inventory.Inverntory.models.Category;
import com.inventory.Inverntory.models.Product;
import com.inventory.Inverntory.models.Supplier;
import com.inventory.Inverntory.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {

    @Autowired
    private final CategoryRepository categoryRepository;


    public CategoryService(com.inventory.Inverntory.repositories.CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Product> getAllProductsForCategory(Long id) {
        Category category = categoryRepository.findCategoryById(id).orElse(null);
        return category.getProducts();
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Long id){
        return categoryRepository.findCategoryById(id);
    }

    public Category addCategory(Category category){
        return categoryRepository.save(category);
    }
    public Optional<Category> updateCategory(Long id,Category category){
        Optional<Category> existingCategory = categoryRepository.findCategoryById(id);
        if (existingCategory.isPresent()) {
            Category updatedCategory = existingCategory.get();
            updatedCategory.setName(category.getName());
            updatedCategory.setDescription(category.getDescription());
            categoryRepository.save(updatedCategory);
        }
        return existingCategory;
    }

    public void removeCategory(Long id) {
        categoryRepository.deleteCategoryById(id);
    }


}
