package com.example.wms.service;


import com.example.wms.entity.Warehouses;
import com.example.wms.repository.WarehousesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehousesService {

    @Autowired
    private WarehousesRepository warehousesRepository;

    public List<Warehouses> getAllWarehouses() {
        return warehousesRepository.findAll();
    }

    public Optional<Warehouses> getWarehouseById(String id) {
        return warehousesRepository.findById(id);
    }

    public Warehouses createWarehouse(Warehouses warehouse) {
        return warehousesRepository.save(warehouse);
    }

    public Warehouses updateWarehouse(String id, Warehouses warehouseDetails) {
        Warehouses warehouse = warehousesRepository.findById(id).orElseThrow();
        warehouse.setWarehouseName(warehouseDetails.getWarehouseName());
        warehouse.setAddress(warehouseDetails.getAddress());
        return warehousesRepository.save(warehouse);
    }

    public void deleteWarehouse(String id) {
        warehousesRepository.deleteById(id);
    }
}