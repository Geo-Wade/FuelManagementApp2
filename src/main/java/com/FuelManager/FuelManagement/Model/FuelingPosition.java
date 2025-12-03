package com.FuelManager.FuelManagement.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class FuelingPosition {
    @Id
    int fuelingPositionNumber;
    String fuelingPositionName;
    @ManyToOne
    Product product;

    public int getFuelingPositionNumber() {
        return fuelingPositionNumber;
    }

    public void setFuelingPositionNumber(int fuelingPositionNumber) {
        this.fuelingPositionNumber = fuelingPositionNumber;
    }

    public String getFuelingPositionName() {
        return fuelingPositionName;
    }

    public void setFuelingPositionName(String fuelingPositionName) {
        this.fuelingPositionName = fuelingPositionName;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "FuelingPosition{" +
                "fuelingPositionNumber=" + fuelingPositionNumber +
                ", fuelingPositionName='" + fuelingPositionName + '\'' +
                ", product='" + product + '\'' +
                '}';
    }
}
