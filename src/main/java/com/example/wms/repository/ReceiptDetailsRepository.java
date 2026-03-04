package com.example.wms.repository;

import com.example.wms.entity.ReceiptDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptDetailsRepository extends JpaRepository<ReceiptDetails, Integer> {
}