package com.fuel.manager.dao.model.tables.transaction;

import com.fuel.manager.dao.model.tables.authrorized.equipment.Equipment;
import com.fuel.manager.dao.model.tables.authrorized.operator.Operator;
import jakarta.persistence.*;

@Entity
public class StartupTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int transactionID;
    @ManyToOne
    Equipment EquipmentId;
    @ManyToOne
    Operator operatorId;
    int fuelingPosition;
    boolean didAuthorize;

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public Equipment getEquipmentId() {
        return EquipmentId;
    }

    public void setEquipmentId(Equipment equipmentId) {
        EquipmentId = equipmentId;
    }

    public Operator getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Operator operatorId) {
        this.operatorId = operatorId;
    }

    public int getFuelingPosition() {
        return fuelingPosition;
    }

    public void setFuelingPosition(int fuelingPosition) {
        this.fuelingPosition = fuelingPosition;
    }

    public boolean isDidAuthorize() {
        return didAuthorize;
    }

    public void setDidAuthorize(boolean didAuthorize) {
        this.didAuthorize = didAuthorize;
    }

    @Override
    public String toString() {
        return "ActiveTransaction{" +
                "transactionID=" + transactionID +
                ", EquipmentId=" + EquipmentId +
                ", operatorId=" + operatorId +
                '}';
    }
}
