package com.example.wms.controller;

import com.example.wms.entity.Products;
import com.example.wms.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsRepository productsRepository;

    @GetMapping
    public List<Products> getAllProducts() {
        return productsRepository.findAll();
    }

    @PostMapping
    public Products createProduct(@RequestBody Products product) {
        return productsRepository.save(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable String id) {
        return productsRepository.findById(id)
                .map(product -> ResponseEntity.ok(product))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Products> updateProduct(@PathVariable String id, @RequestBody Products productDetails) {
        return productsRepository.findById(id)
                .map(product -> {
                    product.setProductName(productDetails.getProductName());
                    product.setUnitOfMeasure(productDetails.getUnitOfMeasure());
                    product.setDefaultPurchasePrice(productDetails.getDefaultPurchasePrice());
                    product.setDefaultSalePrice(productDetails.getDefaultSalePrice());
                    return ResponseEntity.ok(productsRepository.save(product));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable String id) {
        return productsRepository.findById(id)
                .map(product -> {
                    productsRepository.delete(product);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}