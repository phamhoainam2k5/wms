package com.example.wms.repository;

import com.example.wms.entity.Warehouses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehousesRepository extends JpaRepository<Warehouses, String> {
}