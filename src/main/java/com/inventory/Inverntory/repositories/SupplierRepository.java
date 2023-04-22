package com.inventory.Inverntory.repositories;

import com.inventory.Inverntory.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    Optional<Supplier> findSupplierById(Long id);

    void deleteSupplierById(Long id);
}
