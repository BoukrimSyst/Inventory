package com.inventory.Inverntory.repositories;

import com.inventory.Inverntory.models.Supplier;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
@Transactional
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    Optional<Supplier> findSupplierById(Long id);

    void deleteSupplierById(Long id);
}
