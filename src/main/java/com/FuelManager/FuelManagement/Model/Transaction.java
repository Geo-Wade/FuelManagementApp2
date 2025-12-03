package com.FuelManager.FuelManagement.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int TransactionID;
    LocalDateTime transactionTime;
    String operatorID;
    @OneToOne
    Equipment equipment;
    int fuelingPosition;
    double amountFueled;

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getOperatorID() {
        return operatorID;
    }

    public void setOperatorID(String operatorID) {
        this.operatorID = operatorID;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public int getFuelingPosition() {
        return fuelingPosition;
    }

    public void setFuelingPosition(int fuelingPosition) {
        this.fuelingPosition = fuelingPosition;
    }

    public double getAmountFueled() {
        return amountFueled;
    }

    public void setAmountFueled(double amountFueled) {
        this.amountFueled = amountFueled;
    }

    public int getTransactionID() {
        return TransactionID;
    }

    public void setTransactionID(int transactionID) {
        TransactionID = transactionID;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "TransactionID=" + TransactionID +
                ", transactionTime=" + transactionTime +
                ", operatorID='" + operatorID + '\'' +
                ", equipmentID='" + equipment + '\'' +
                ", fuelingPosition=" + fuelingPosition +
                ", amountFueled=" + amountFueled +
                '}';
    }
}
