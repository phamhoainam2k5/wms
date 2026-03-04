package com.example.wms.repository;

import com.example.wms.entity.Receipts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptsRepository extends JpaRepository<Receipts, String> {
}