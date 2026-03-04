package com.example.wms.service;


import com.example.wms.entity.Products;
import com.example.wms.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    public List<Products> getAllProducts() {
        return productsRepository.findAll();
    }

    public Optional<Products> getProductById(String id) {
        return productsRepository.findById(id);
    }

    public Products createProduct(Products product) {
        return productsRepository.save(product);
    }

    public Products updateProduct(String id, Products productDetails) {
        Products product = productsRepository.findById(id).orElseThrow();
        product.setProductName(productDetails.getProductName());
        product.setUnitOfMeasure(productDetails.getUnitOfMeasure());
        product.setDefaultPurchasePrice(productDetails.getDefaultPurchasePrice());
        product.setDefaultSalePrice(productDetails.getDefaultSalePrice());
        return productsRepository.save(product);
    }

    public void deleteProduct(String id) {
        productsRepository.deleteById(id);
    }
}