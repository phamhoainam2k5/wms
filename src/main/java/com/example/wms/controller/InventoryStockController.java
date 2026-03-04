package com.example.wms.controller;

import com.example.wms.entity.InventoryStock;
import com.example.wms.repository.InventoryStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory-stock")
public class InventoryStockController {

    @Autowired
    private InventoryStockRepository inventoryStockRepository;

    @GetMapping
    public List<InventoryStock> getAllInventoryStocks() {
        return inventoryStockRepository.findAll();
    }

    @PostMapping
    public InventoryStock createInventoryStock(@RequestBody InventoryStock inventoryStock) {
        return inventoryStockRepository.save(inventoryStock);
    }

    @GetMapping("/{productId}/{warehouseId}")
    public ResponseEntity<InventoryStock> getInventoryStockById(@PathVariable String productId, @PathVariable String warehouseId) {
        return inventoryStockRepository.findByIdAndWarehouseId(productId, warehouseId)
                .map(inventoryStock -> ResponseEntity.ok(inventoryStock))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{productId}/{warehouseId}")
    public ResponseEntity<InventoryStock> updateInventoryStock(
            @PathVariable String productId, 
            @PathVariable String warehouseId, 
            @RequestBody InventoryStock inventoryStockDetails) {

        return inventoryStockRepository.findByIdAndWarehouseId(productId, warehouseId)
                .map(inventoryStock -> {
                    inventoryStock.setStockQuantity(inventoryStockDetails.getStockQuantity());
                    inventoryStock.setLastUpdatedDate(inventoryStockDetails.getLastUpdatedDate());
                    return ResponseEntity.ok(inventoryStockRepository.save(inventoryStock));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{productId}/{warehouseId}")
    public ResponseEntity<Object> deleteInventoryStock(@PathVariable String productId, @PathVariable String warehouseId) {
        return inventoryStockRepository.findByIdAndWarehouseId(productId, warehouseId)
                .map(inventoryStock -> {
                    inventoryStockRepository.delete(inventoryStock);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}