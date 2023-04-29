package com.inventory.Inverntory.services;

import com.inventory.Inverntory.models.Supplier;
import com.inventory.Inverntory.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;



@Service
public class SupplierService {




    private static SupplierRepository supplierRepository;


    @Autowired
    public SupplierService(SupplierRepository supplierRepository) {
        SupplierService.supplierRepository = supplierRepository;
    }

    public List<Supplier> findAllSuppliers(){
        return supplierRepository.findAll();
    }

    public static Supplier findSupplierById(Long id){
        return supplierRepository.findSupplierById(id)
                .orElseThrow(() -> new RuntimeException("User by Id "+ id +"was not found"));

    }

    public Supplier addSupplier(Supplier supplier){
        supplier.setId(UUID.randomUUID());
        return supplierRepository.save(supplier);
    }



    public void deleteSupplier(Long id){
        supplierRepository.deleteSupplierById(id);
    }

    public Supplier updateSupplier(Supplier supplier){
        return supplierRepository.save(supplier);
    }
}
