package com.example.wms.service;


import com.example.wms.entity.ReceiptDetails;
import com.example.wms.repository.ReceiptDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceiptDetailsService {

    @Autowired
    private ReceiptDetailsRepository receiptDetailsRepository;

    public List<ReceiptDetails> getAllReceiptDetails() {
        return receiptDetailsRepository.findAll();
    }

    public Optional<ReceiptDetails> getReceiptDetailById(Integer id) {
        return receiptDetailsRepository.findById(id);
    }

    public ReceiptDetails createReceiptDetail(ReceiptDetails receiptDetail) {
        return receiptDetailsRepository.save(receiptDetail);
    }

    public ReceiptDetails updateReceiptDetail(Integer id, ReceiptDetails receiptDetailDetails) {
        ReceiptDetails receiptDetail = receiptDetailsRepository.findById(id).orElseThrow();
        receiptDetail.setQuantityReceived(receiptDetailDetails.getQuantityReceived());
        receiptDetail.setUnitPurchasePrice(receiptDetailDetails.getUnitPurchasePrice());
        receiptDetail.setWarehouse(receiptDetailDetails.getWarehouse());
        return receiptDetailsRepository.save(receiptDetail);
    }

    public void deleteReceiptDetail(Integer id) {
        receiptDetailsRepository.deleteById(id);
    }
}