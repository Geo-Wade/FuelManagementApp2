package com.FuelManager.FuelManagement.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int transactionID;
    LocalDateTime transactionTime;
    @ManyToOne
    Operator operator;
    @ManyToOne
    Equipment equipment;
    int fuelingPosition;
    double amountFueled;

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operatorID) {
        this.operator = operatorID;
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
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        transactionID = transactionID;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "TransactionID=" + transactionID +
                ", transactionTime=" + transactionTime +
                ", operatorID='" + operator + '\'' +
                ", equipmentID='" + equipment + '\'' +
                ", fuelingPosition=" + fuelingPosition +
                ", amountFueled=" + amountFueled +
                '}';
    }
}
