package com.example.wms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ISSUE_DETAILS")
public class IssueDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer issueDetailId;

    @ManyToOne
    @JoinColumn(name = "Issue_ID")
    private Issues issue;

    @ManyToOne
    @JoinColumn(name = "Product_ID")
    private Products product;

    @Column(name = "Quantity_Issued", nullable = false)
    private Integer quantityIssued;

    @Column(name = "Unit_Sale_Price", nullable = false)
    private Double unitSalePrice;

    @ManyToOne
    @JoinColumn(name = "Warehouse_ID")
    private Warehouses warehouse;

    public Integer getIssueDetailId() {
        return issueDetailId;
    }

    public void setIssueDetailId(Integer issueDetailId) {
        this.issueDetailId = issueDetailId;
    }

    public Issues getIssue() {
        return issue;
    }

    public void setIssue(Issues issue) {
        this.issue = issue;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public Integer getQuantityIssued() {
        return quantityIssued;
    }

    public void setQuantityIssued(Integer quantityIssued) {
        this.quantityIssued = quantityIssued;
    }

    public Double getUnitSalePrice() {
        return unitSalePrice;
    }

    public void setUnitSalePrice(Double unitSalePrice) {
        this.unitSalePrice = unitSalePrice;
    }

    public Warehouses getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouses warehouse) {
        this.warehouse = warehouse;
    }

}
