package com.example.wms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUCTS")
public class Products {
    @Id
    private String productId;

    @Column(name = "Product_Name", nullable = false)
    private String productName;

    @Column(name = "Unit_Of_Measure", nullable = false)
    private String unitOfMeasure;

    @Column(name = "Default_Purchase_Price")
    private Double defaultPurchasePrice;

    @Column(name = "Default_Sale_Price")
    private Double defaultSalePrice;

    @ManyToOne
    @JoinColumn(name = "Supplier_ID")
    private Suppliers supplier;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public Double getDefaultPurchasePrice() {
        return defaultPurchasePrice;
    }

    public void setDefaultPurchasePrice(Double defaultPurchasePrice) {
        this.defaultPurchasePrice = defaultPurchasePrice;
    }

    public Double getDefaultSalePrice() {
        return defaultSalePrice;
    }

    public void setDefaultSalePrice(Double defaultSalePrice) {
        this.defaultSalePrice = defaultSalePrice;
    }

    public Suppliers getSupplier() {
        return supplier;
    }

    public void setSupplier(Suppliers supplier) {
        this.supplier = supplier;
    }

}