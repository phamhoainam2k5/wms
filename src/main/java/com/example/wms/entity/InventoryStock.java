package com.example.wms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "INVENTORY_STOCK")
public class InventoryStock {
    @Id
    @ManyToOne
    @JoinColumn(name = "Product_ID")
    private Products product;

    @Id
    @ManyToOne
    @JoinColumn(name = "Warehouse_ID")
    private Warehouses warehouse;

    @Column(name = "Stock_Quantity", nullable = false)
    private Integer stockQuantity;

    @Column(name = "Last_Updated_Date", nullable = false)
    private java.util.Date lastUpdatedDate;

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public Warehouses getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouses warehouse) {
        this.warehouse = warehouse;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public java.util.Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(java.util.Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

}