package com.FuelManager.FuelManagement.Model;

import jakarta.persistence.*;
@Entity
public class Product {
    @Id
    String productId;



    public String getProductName() {
        return productId;
    }

    public void setProductName(String productName) {
        this.productId = productName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                '}';
    }
}
