package com.example.wms.controller;

import com.example.wms.entity.ReceiptDetails;
import com.example.wms.repository.ReceiptDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receipt-details")
public class ReceiptDetailsController {

    @Autowired
    private ReceiptDetailsRepository receiptDetailsRepository;

    @GetMapping
    public List<ReceiptDetails> getAllReceiptDetails() {
        return receiptDetailsRepository.findAll();
    }

    @PostMapping
    public ReceiptDetails createReceiptDetail(@RequestBody ReceiptDetails receiptDetail) {
        return receiptDetailsRepository.save(receiptDetail);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceiptDetails> getReceiptDetailById(@PathVariable Integer id) {
        return receiptDetailsRepository.findById(id)
                .map(receiptDetail -> ResponseEntity.ok(receiptDetail))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReceiptDetails> updateReceiptDetail(@PathVariable Integer id, @RequestBody ReceiptDetails receiptDetailDetails) {
        return receiptDetailsRepository.findById(id)
                .map(receiptDetail -> {
                    receiptDetail.setQuantityReceived(receiptDetailDetails.getQuantityReceived());
                    receiptDetail.setUnitPurchasePrice(receiptDetailDetails.getUnitPurchasePrice());
                    receiptDetail.setWarehouse(receiptDetailDetails.getWarehouse());
                    return ResponseEntity.ok(receiptDetailsRepository.save(receiptDetail));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteReceiptDetail(@PathVariable Integer id) {
        return receiptDetailsRepository.findById(id)
                .map(receiptDetail -> {
                    receiptDetailsRepository.delete(receiptDetail);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}