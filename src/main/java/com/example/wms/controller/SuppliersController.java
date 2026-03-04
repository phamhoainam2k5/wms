package com.example.wms.controller;

import com.example.wms.entity.Suppliers;
import com.example.wms.repository.SuppliersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
public class SuppliersController {

    @Autowired
    private SuppliersRepository suppliersRepository;

    @GetMapping
    public List<Suppliers> getAllSuppliers() {
        return suppliersRepository.findAll();
    }

    @PostMapping
    public Suppliers createSupplier(@RequestBody Suppliers supplier) {
        return suppliersRepository.save(supplier);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Suppliers> getSupplierById(@PathVariable String id) {
        return suppliersRepository.findById(id)
                .map(supplier -> ResponseEntity.ok(supplier))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Suppliers> updateSupplier(@PathVariable String id, @RequestBody Suppliers supplierDetails) {
        return suppliersRepository.findById(id)
                .map(supplier -> {
                    supplier.setSupplierName(supplierDetails.getSupplierName());
                    supplier.setPhoneNumber(supplierDetails.getPhoneNumber());
                    supplier.setAddress(supplierDetails.getAddress());
                    return ResponseEntity.ok(suppliersRepository.save(supplier));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSupplier(@PathVariable String id) {
        return suppliersRepository.findById(id)
                .map(supplier -> {
                    suppliersRepository.delete(supplier);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}