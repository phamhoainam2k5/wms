package com.example.wms.service;


import com.example.wms.entity.Issues;
import com.example.wms.repository.IssuesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IssuesService {

    @Autowired
    private IssuesRepository issuesRepository;

    public List<Issues> getAllIssues() {
        return issuesRepository.findAll();
    }

    public Optional<Issues> getIssueById(String id) {
        return issuesRepository.findById(id);
    }

    public Issues createIssue(Issues issue) {
        return issuesRepository.save(issue);
    }

    public Issues updateIssue(String id, Issues issueDetails) {
        Issues issue = issuesRepository.findById(id).orElseThrow();
        issue.setIssueDate(issueDetails.getIssueDate());
        issue.setCustomer(issueDetails.getCustomer());
        issue.setTotalAmount(issueDetails.getTotalAmount());
        return issuesRepository.save(issue);
    }

    public void deleteIssue(String id) {
        issuesRepository.deleteById(id);
    }
}