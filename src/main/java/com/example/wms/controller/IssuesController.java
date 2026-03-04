package com.example.wms.controller;

import com.example.wms.entity.Issues;
import com.example.wms.repository.IssuesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/issues")
public class IssuesController {

    @Autowired
    private IssuesRepository issuesRepository;

    @GetMapping
    public List<Issues> getAllIssues() {
        return issuesRepository.findAll();
    }

    @PostMapping
    public Issues createIssue(@RequestBody Issues issue) {
        return issuesRepository.save(issue);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Issues> getIssueById(@PathVariable String id) {
        return issuesRepository.findById(id)
                .map(issue -> ResponseEntity.ok(issue))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Issues> updateIssue(@PathVariable String id, @RequestBody Issues issueDetails) {
        return issuesRepository.findById(id)
                .map(issue -> {
                    issue.setIssueDate(issueDetails.getIssueDate());
                    issue.setCustomer(issueDetails.getCustomer());
                    issue.setTotalAmount(issueDetails.getTotalAmount());
                    return ResponseEntity.ok(issuesRepository.save(issue));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteIssue(@PathVariable String id) {
        return issuesRepository.findById(id)
                .map(issue -> {
                    issuesRepository.delete(issue);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}