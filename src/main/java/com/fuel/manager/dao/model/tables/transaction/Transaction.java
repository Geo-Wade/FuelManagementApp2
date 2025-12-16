package com.fuel.manager.dao.model.tables.transaction;

import com.fuel.manager.dao.model.tables.authrorized.equipment.Equipment;
import com.fuel.manager.dao.model.tables.authrorized.operator.Operator;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int transactionID;
    LocalDateTime transactionTime;
    @ManyToOne
            //COLUMN
    Operator operator;
    @ManyToOne
            //COLUMN
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
        this.transactionID = transactionID;
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
