package com.example.wms.service;

import com.example.wms.entity.Suppliers;
import com.example.wms.repository.SuppliersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuppliersService {

    @Autowired
    private SuppliersRepository suppliersRepository;

    public List<Suppliers> getAllSuppliers() {
        return suppliersRepository.findAll();
    }

    public Optional<Suppliers> getSupplierById(String id) {
        return suppliersRepository.findById(id);
    }

    public Suppliers createSupplier(Suppliers supplier) {
        return suppliersRepository.save(supplier);
    }

    public Suppliers updateSupplier(String id, Suppliers supplierDetails) {
        Suppliers supplier = suppliersRepository.findById(id).orElseThrow();
        supplier.setSupplierName(supplierDetails.getSupplierName());
        supplier.setPhoneNumber(supplierDetails.getPhoneNumber());
        supplier.setAddress(supplierDetails.getAddress());
        return suppliersRepository.save(supplier);
    }

    public void deleteSupplier(String id) {
        suppliersRepository.deleteById(id);
    }
}