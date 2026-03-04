package com.example.wms.controller;

import com.example.wms.entity.IssueDetails;
import com.example.wms.repository.IssueDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/issue-details")
public class IssueDetailsController {

    @Autowired
    private IssueDetailsRepository issueDetailsRepository;

    @GetMapping
    public List<IssueDetails> getAllIssueDetails() {
        return issueDetailsRepository.findAll();
    }

    @PostMapping
    public IssueDetails createIssueDetail(@RequestBody IssueDetails issueDetail) {
        return issueDetailsRepository.save(issueDetail);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IssueDetails> getIssueDetailById(@PathVariable Integer id) {
        return issueDetailsRepository.findById(id)
                .map(issueDetail -> ResponseEntity.ok(issueDetail))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<IssueDetails> updateIssueDetail(@PathVariable Integer id, @RequestBody IssueDetails issueDetailDetails) {
        return issueDetailsRepository.findById(id)
                .map(issueDetail -> {
                    issueDetail.setQuantityIssued(issueDetailDetails.getQuantityIssued());
                    issueDetail.setUnitSalePrice(issueDetailDetails.getUnitSalePrice());
                    issueDetail.setWarehouse(issueDetailDetails.getWarehouse());
                    return ResponseEntity.ok(issueDetailsRepository.save(issueDetail));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteIssueDetail(@PathVariable Integer id) {
        return issueDetailsRepository.findById(id)
                .map(issueDetail -> {
                    issueDetailsRepository.delete(issueDetail);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}