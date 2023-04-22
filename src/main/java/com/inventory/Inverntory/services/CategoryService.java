package com.inventory.Inverntory.services;


import com.inventory.Inverntory.models.Category;
import com.inventory.Inverntory.models.Supplier;
import com.inventory.Inverntory.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;


    @Autowired
    public CategoryService(com.inventory.Inverntory.repositories.CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id){
        return categoryRepository.findCategoryById(id)
                .orElseThrow(() -> new RuntimeException("Category by ID "+ id +"was not found !"));
    }

    public Category addCategory(Category category){
        category.setId(Long.valueOf(UUID.randomUUID().toString()));
        return categoryRepository.save(category);
    }
    public Category updateCategory(Category category){
        return categoryRepository.save(category);
    }

    public void removeCategory(Long id) {
        categoryRepository.deleteCategoryById(id);
    }


}
