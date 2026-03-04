package com.example.wms.service;


import com.example.wms.entity.IssueDetails;
import com.example.wms.repository.IssueDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IssueDetailsService {

    @Autowired
    private IssueDetailsRepository issueDetailsRepository;

    public List<IssueDetails> getAllIssueDetails() {
        return issueDetailsRepository.findAll();
    }

    public Optional<IssueDetails> getIssueDetailById(Integer id) {
        return issueDetailsRepository.findById(id);
    }

    public IssueDetails createIssueDetail(IssueDetails issueDetail) {
        return issueDetailsRepository.save(issueDetail);
    }

    public IssueDetails updateIssueDetail(Integer id, IssueDetails issueDetailDetails) {
        IssueDetails issueDetail = issueDetailsRepository.findById(id).orElseThrow();
        issueDetail.setQuantityIssued(issueDetailDetails.getQuantityIssued());
        issueDetail.setUnitSalePrice(issueDetailDetails.getUnitSalePrice());
        issueDetail.setWarehouse(issueDetailDetails.getWarehouse());
        return issueDetailsRepository.save(issueDetail);
    }

    public void deleteIssueDetail(Integer id) {
        issueDetailsRepository.deleteById(id);
    }
}