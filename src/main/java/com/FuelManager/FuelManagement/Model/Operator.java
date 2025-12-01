package com.FuelManager.FuelManagement.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Operator {
    @Id
    String operatorID;
    String operatorFirstName;
    String operatorLastName;
}
