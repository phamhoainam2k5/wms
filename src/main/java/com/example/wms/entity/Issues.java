package com.example.wms.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ISSUES")
public class Issues {
    @Id
    private String issueId;

    @Column(name = "Issue_Date", nullable = false)
    private Date issueDate;

    @ManyToOne
    @JoinColumn(name = "Customer_ID")
    private Customers customer;

    @Column(name = "Total_Amount")
    private Double totalAmount;

    @ManyToOne
    @JoinColumn(name = "Creator_User")
    private Users creatorUser;

    public String getIssueId() {
        return issueId;
    }

    public void setIssueId(String issueId) {
        this.issueId = issueId;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Users getCreatorUser() {
        return creatorUser;
    }

    public void setCreatorUser(Users creatorUser) {
        this.creatorUser = creatorUser;
    }

}
