package com.example.wms.controller;

import com.example.wms.entity.Receipts;
import com.example.wms.repository.ReceiptsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receipts")
public class ReceiptsController {

    @Autowired
    private ReceiptsRepository receiptsRepository;

    @GetMapping
    public List<Receipts> getAllReceipts() {
        return receiptsRepository.findAll();
    }

    @PostMapping
    public Receipts createReceipt(@RequestBody Receipts receipt) {
        return receiptsRepository.save(receipt);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Receipts> getReceiptById(@PathVariable String id) {
        return receiptsRepository.findById(id)
                .map(receipt -> ResponseEntity.ok(receipt))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Receipts> updateReceipt(@PathVariable String id, @RequestBody Receipts receiptDetails) {
        return receiptsRepository.findById(id)
                .map(receipt -> {
                    receipt.setReceiptDate(receiptDetails.getReceiptDate());
                    receipt.setSupplier(receiptDetails.getSupplier());
                    receipt.setTotalAmount(receiptDetails.getTotalAmount());
                    return ResponseEntity.ok(receiptsRepository.save(receipt));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteReceipt(@PathVariable String id) {
        return receiptsRepository.findById(id)
                .map(receipt -> {
                    receiptsRepository.delete(receipt);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}