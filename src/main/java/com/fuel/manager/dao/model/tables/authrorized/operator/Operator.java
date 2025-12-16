package com.fuel.manager.dao.model.tables.authrorized.operator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Operator {
    @Id
    String operatorID;
    String operatorFirstName;
    String operatorLastName;

    public String getOperatorID() {
        return operatorID;
    }

    public void setOperatorID(String operatorID) {
        this.operatorID = operatorID;
    }

    public String getOperatorFirstName() {
        return operatorFirstName;
    }

    public void setOperatorFirstName(String operatorFirstName) {
        this.operatorFirstName = operatorFirstName;
    }

    public String getOperatorLastName() {
        return operatorLastName;
    }

    public void setOperatorLastName(String operatorLastName) {
        this.operatorLastName = operatorLastName;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "operatorID='" + operatorID + '\'' +
                ", operatorFirstName='" + operatorFirstName + '\'' +
                ", operatorLastName='" + operatorLastName + '\'' +
                '}';
    }
}
