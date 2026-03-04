package com.example.wms.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "RECEIPTS")
public class Receipts {
    @Id
    private String receiptId;

    @Column(name = "Receipt_Date", nullable = false)
    private Date receiptDate;

    @ManyToOne
    @JoinColumn(name = "Supplier_ID")
    private Suppliers supplier;

    @Column(name = "Total_Amount")
    private Double totalAmount;

    @ManyToOne
    @JoinColumn(name = "Creator_User")
    private Users creatorUser;

    public String getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(String receiptId) {
        this.receiptId = receiptId;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public Suppliers getSupplier() {
        return supplier;
    }

    public void setSupplier(Suppliers supplier) {
        this.supplier = supplier;
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