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
@Table(name = "RECEIPT_DETAILS")
public class ReceiptDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer receiptDetailId;

    @ManyToOne
    @JoinColumn(name = "Receipt_ID")
    private Receipts receipt;

    @ManyToOne
    @JoinColumn(name = "Product_ID")
    private Products product;

    @Column(name = "Quantity_Received", nullable = false)
    private Integer quantityReceived;

    @Column(name = "Unit_Purchase_Price", nullable = false)
    private Double unitPurchasePrice;

    @ManyToOne
    @JoinColumn(name = "Warehouse_ID")
    private Warehouses warehouse;

    public Integer getReceiptDetailId() {
        return receiptDetailId;
    }

    public void setReceiptDetailId(Integer receiptDetailId) {
        this.receiptDetailId = receiptDetailId;
    }

    public Receipts getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipts receipt) {
        this.receipt = receipt;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public Integer getQuantityReceived() {
        return quantityReceived;
    }

    public void setQuantityReceived(Integer quantityReceived) {
        this.quantityReceived = quantityReceived;
    }

    public Double getUnitPurchasePrice() {
        return unitPurchasePrice;
    }

    public void setUnitPurchasePrice(Double unitPurchasePrice) {
        this.unitPurchasePrice = unitPurchasePrice;
    }

    public Warehouses getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouses warehouse) {
        this.warehouse = warehouse;
    }
    
}