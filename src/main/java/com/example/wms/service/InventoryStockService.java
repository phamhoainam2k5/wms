package com.example.wms.service;

import com.example.wms.entity.InventoryStock;
import com.example.wms.repository.InventoryStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryStockService {

    @Autowired
    private InventoryStockRepository inventoryStockRepository;

    public List<InventoryStock> getAllInventoryStocks() {
        return inventoryStockRepository.findAll();
    }

    public Optional<InventoryStock> getInventoryStockById(String productId, String warehouseId) {
        return inventoryStockRepository.findByIdAndWarehouseId(productId, warehouseId);
    }

    public InventoryStock createInventoryStock(InventoryStock inventoryStock) {
        return inventoryStockRepository.save(inventoryStock);
    }

    public InventoryStock updateInventoryStock(String productId, String warehouseId, InventoryStock inventoryStockDetails) {
        InventoryStock inventoryStock = inventoryStockRepository.findByIdAndWarehouseId(productId, warehouseId).orElseThrow();
        inventoryStock.setStockQuantity(inventoryStockDetails.getStockQuantity());
        inventoryStock.setLastUpdatedDate(inventoryStockDetails.getLastUpdatedDate());
        return inventoryStockRepository.save(inventoryStock);
    }

    public void deleteInventoryStock(String productId, String warehouseId) {
        InventoryStock inventoryStock = inventoryStockRepository.findByIdAndWarehouseId(productId, warehouseId).orElseThrow();
        inventoryStockRepository.delete(inventoryStock);
    }
    
}