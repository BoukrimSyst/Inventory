package com.inventory.Inverntory.controllers;
import com.inventory.Inverntory.models.Supplier;
import com.inventory.Inverntory.services.SupplierService;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@RestController
@Configuration
@EnableWebMvc
@RequestMapping("/supplier")
public class SupplierController {
    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("/all/suppliers")
    public ResponseEntity<List<Supplier>> findAllSuppliers(){
        List<Supplier> suppliers = supplierService.findAllSuppliers();
        return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }

    @GetMapping("/find/supplier/{id}")
    public ResponseEntity<Supplier> findSupplierById(@PathVariable("id") Long id){
        Supplier supplier = SupplierService.findSupplierById(id);
        return new ResponseEntity<>(supplier, HttpStatus.OK);
    }

    @PostMapping("/add/supplier")
    public ResponseEntity<Supplier> addSupplier(@RequestBody Supplier supplier){
        Supplier newSupplier = supplierService.addSupplier(supplier);
        return new ResponseEntity<>(newSupplier, HttpStatus.CREATED);
    }

    @PutMapping("/update/supplier")
    public ResponseEntity<Supplier> updateSupplier(@RequestBody Supplier supplier){
        Supplier updatedSupplier = supplierService.updateSupplier(supplier);
        return new ResponseEntity<>(updatedSupplier, HttpStatus.CREATED);
    }

    @DeleteMapping("/Delete/supplier/{id}")
    public ResponseEntity<?> deleteSupplier(@PathVariable("id") Long id){
        supplierService.deleteSupplier(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
