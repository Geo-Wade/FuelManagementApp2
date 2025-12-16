package com.fuel.manager.dao.model.tables.controlled.fueling;

import com.fuel.manager.dao.model.tables.accounted.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

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
