package com.example.wms.service;

import com.example.wms.entity.Customers;
import com.example.wms.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomersService {

    @Autowired
    private CustomersRepository customersRepository;

    public List<Customers> getAllCustomers() {
        return customersRepository.findAll();
    }

    public Optional<Customers> getCustomerById(String id) {
        return customersRepository.findById(id);
    }

    public Customers createCustomer(Customers customer) {
        return customersRepository.save(customer);
    }

    public Customers updateCustomer(String id, Customers customerDetails) {
        Customers customer = customersRepository.findById(id).orElseThrow();
        customer.setCustomerName(customerDetails.getCustomerName());
        customer.setPhoneNumber(customerDetails.getPhoneNumber());
        customer.setAddress(customerDetails.getAddress());
        return customersRepository.save(customer);
    }

    public void deleteCustomer(String id) {
        customersRepository.deleteById(id);
    }
}