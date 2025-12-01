package com.FuelManager.FuelManagement.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int TransactionID;
    LocalDateTime transactionTime;
    String operatorID;
    String equipmentID;
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

    public String getEquipmentID() {
        return equipmentID;
    }

    public void setEquipmentID(String equipmentID) {
        this.equipmentID = equipmentID;
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

    public void setAmountFueled(double amoungFueled) {
        this.amountFueled = amoungFueled;
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
                ", equipmentID='" + equipmentID + '\'' +
                ", fuelingPosition=" + fuelingPosition +
                ", amountFueled=" + amountFueled +
                '}';
    }
}
