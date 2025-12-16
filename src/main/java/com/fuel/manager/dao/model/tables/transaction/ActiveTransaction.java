package com.fuel.manager.dao.model.tables.transaction;

import jakarta.persistence.*;

@Entity
public class ActiveTransaction {
    @Id
    int fuelingPosition;
    @OneToOne
    Transaction transaction;

    public int getFuelingPosition() {
        return fuelingPosition;
    }

    public void setFuelingPosition(int fuelingPosition) {
        this.fuelingPosition = fuelingPosition;
    }

    public Transaction getTransactions() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
