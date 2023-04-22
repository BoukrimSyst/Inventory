package com.inventory.Inverntory.repositories;

import com.inventory.Inverntory.models.Category;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Transactional
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findCategoryById(Long id);

    void deleteCategoryById(Long id);
}
