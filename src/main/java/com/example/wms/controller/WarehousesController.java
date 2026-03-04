package com.example.wms.controller;

import com.example.wms.entity.Warehouses;
import com.example.wms.repository.WarehousesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouses")
public class WarehousesController {

    @Autowired
    private WarehousesRepository warehousesRepository;

    @GetMapping
    public List<Warehouses> getAllWarehouses() {
        return warehousesRepository.findAll();
    }

    @PostMapping
    public Warehouses createWarehouse(@RequestBody Warehouses warehouse) {
        return warehousesRepository.save(warehouse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Warehouses> getWarehouseById(@PathVariable String id) {
        return warehousesRepository.findById(id)
                .map(warehouse -> ResponseEntity.ok(warehouse))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Warehouses> updateWarehouse(@PathVariable String id, @RequestBody Warehouses warehouseDetails) {
        return warehousesRepository.findById(id)
                .map(warehouse -> {
                    warehouse.setWarehouseName(warehouseDetails.getWarehouseName());
                    warehouse.setAddress(warehouseDetails.getAddress());
                    return ResponseEntity.ok(warehousesRepository.save(warehouse));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteWarehouse(@PathVariable String id) {
        return warehousesRepository.findById(id)
                .map(warehouse -> {
                    warehousesRepository.delete(warehouse);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}