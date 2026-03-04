package com.example.wms.repository;

import com.example.wms.entity.IssueDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueDetailsRepository extends JpaRepository<IssueDetails, Integer> {
}