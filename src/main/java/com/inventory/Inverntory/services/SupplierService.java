package com.inventory.Inverntory.services;

import com.inventory.Inverntory.models.Supplier;
import com.inventory.Inverntory.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;



@Service
public class SupplierService {



    @Autowired
    private static SupplierRepository supplierRepository;


    public SupplierService(SupplierRepository supplierRepository) {
        SupplierService.supplierRepository = supplierRepository;
    }

    public List<Supplier> findAllSuppliers(){
        return supplierRepository.findAll();
    }

    public Optional<Supplier> findSupplierById(Long id){
        return supplierRepository.findSupplierById(id);
    }

    public Supplier addSupplier(Supplier supplier){
        return supplierRepository.save(supplier);
    }



    public void deleteSupplier(Long id){
        supplierRepository.deleteSupplierById(id);
    }

    public Optional<Supplier> updateSupplier(Long id, Supplier supplier){
        Optional<Supplier> existingSupplier = supplierRepository.findSupplierById(id);
        if (existingSupplier.isPresent()) {
            Supplier updatedSupplier = existingSupplier.get();
            updatedSupplier.setName(supplier.getName());
            updatedSupplier.setAddress(supplier.getAddress());
            updatedSupplier.setPhone(supplier.getPhone());
            updatedSupplier.setEmail(supplier.getEmail());
            supplierRepository.save(updatedSupplier);
        }
        return existingSupplier;
    }
}



























