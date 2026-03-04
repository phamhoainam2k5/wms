package com.example.wms.repository;

import com.example.wms.entity.InventoryStock;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryStockRepository extends JpaRepository<InventoryStock, String> {

    Optional<InventoryStock> findByIdAndWarehouseId(String productId, String warehouseId);
}