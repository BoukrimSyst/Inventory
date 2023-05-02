package com.inventory.Inverntory.controllers;
import com.inventory.Inverntory.models.Category;
import com.inventory.Inverntory.models.Supplier;
import com.inventory.Inverntory.services.SupplierService;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;
import java.util.Optional;

@RestController
@Configuration
@EnableWebMvc
@RequestMapping("/supplier")
public class SupplierController {
    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("/all")
    public List<Supplier> findAllSuppliers() {
        return supplierService.findAllSuppliers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> findSupplierById(@PathVariable("id") Long id){
        Supplier supplier = supplierService.findSupplierById(id).orElse(null);
        if (supplier == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(supplier);
    }

    @PostMapping("/add")
    public ResponseEntity<Supplier> addSupplier(@RequestBody Supplier supplier){
        Supplier newSupplier = supplierService.addSupplier(supplier);
        return new ResponseEntity<>(newSupplier, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Supplier> updateSupplier(@PathVariable Long id, @RequestBody Supplier supplier){
        Optional<Supplier> updatedSupplier = supplierService.updateSupplier(id, supplier);
        if (!updatedSupplier.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedSupplier.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSupplier(@PathVariable("id") Long id){
        supplierService.deleteSupplier(id);
        return ResponseEntity.noContent().build();
    }

}
