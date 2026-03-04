package com.example.wms.service;


import com.example.wms.entity.Receipts;
import com.example.wms.repository.ReceiptsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceiptsService {

    @Autowired
    private ReceiptsRepository receiptsRepository;

    public List<Receipts> getAllReceipts() {
        return receiptsRepository.findAll();
    }

    public Optional<Receipts> getReceiptById(String id) {
        return receiptsRepository.findById(id);
    }

    public Receipts createReceipt(Receipts receipt) {
        return receiptsRepository.save(receipt);
    }

    public Receipts updateReceipt(String id, Receipts receiptDetails) {
        Receipts receipt = receiptsRepository.findById(id).orElseThrow();
        receipt.setReceiptDate(receiptDetails.getReceiptDate());
        receipt.setSupplier(receiptDetails.getSupplier());
        receipt.setTotalAmount(receiptDetails.getTotalAmount());
        return receiptsRepository.save(receipt);
    }

    public void deleteReceipt(String id) {
        receiptsRepository.deleteById(id);
    }
}