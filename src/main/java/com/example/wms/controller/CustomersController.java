package com.example.wms.controller;

import com.example.wms.entity.Customers;
import com.example.wms.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomersController {

    @Autowired
    private CustomersRepository customersRepository;

    @GetMapping
    public List<Customers> getAllCustomers() {
        return customersRepository.findAll();
    }

    @PostMapping
    public Customers createCustomer(@RequestBody Customers customer) {
        return customersRepository.save(customer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customers> getCustomerById(@PathVariable String id) {
        return customersRepository.findById(id)
                .map(customer -> ResponseEntity.ok(customer))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customers> updateCustomer(@PathVariable String id, @RequestBody Customers customerDetails) {
        return customersRepository.findById(id)
                .map(customer -> {
                    customer.setCustomerName(customerDetails.getCustomerName());
                    customer.setPhoneNumber(customerDetails.getPhoneNumber());
                    customer.setAddress(customerDetails.getAddress());
                    return ResponseEntity.ok(customersRepository.save(customer));
                })
                .orElse(ResponseEntity.notFound().build());
    }

   @DeleteMapping("/{id}")
public ResponseEntity<Object> deleteCustomer(@PathVariable String id) {
    return customersRepository.findById(id)
        .map(customer -> {
            customersRepository.delete(customer);
            return ResponseEntity.ok().build();
        })
        .orElse(ResponseEntity.notFound().build());
    }
}