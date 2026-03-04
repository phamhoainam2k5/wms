package com.example.wms.repository;

import com.example.wms.entity.Issues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssuesRepository extends JpaRepository<Issues, String> {
}