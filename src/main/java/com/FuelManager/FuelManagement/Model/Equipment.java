package com.FuelManager.FuelManagement.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Equipment {
    @Id
    String id;
    String equipmentMake;
    String equipmentModel;
    int equipmentYear;
    int equipmentOdometer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEquipmentMake() {
        return equipmentMake;
    }

    public void setEquipmentMake(String equipmentMake) {
        this.equipmentMake = equipmentMake;
    }

    public String getEquipmentModel() {
        return equipmentModel;
    }

    public void setEquipmentModel(String equipmentModel) {
        this.equipmentModel = equipmentModel;
    }

    public int getEquipmentYear() {
        return equipmentYear;
    }

    public void setEquipmentYear(int equipmentYear) {
        this.equipmentYear = equipmentYear;
    }

    public int getEquipmentOdometer() {
        return equipmentOdometer;
    }

    public void setEquipmentOdometer(int equipmentOdometer) {
        this.equipmentOdometer = equipmentOdometer;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id='" + id + '\'' +
                ", equipmentMake='" + equipmentMake + '\'' +
                ", equipmentModel='" + equipmentModel + '\'' +
                ", equipmentYear=" + equipmentYear +
                ", equipmentOdometer=" + equipmentOdometer +
                '}';
    }
}
