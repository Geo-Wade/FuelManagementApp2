package com.FuelManager.FuelManagement.Services;

import com.FuelManager.FuelManagement.Model.Equipment;
import com.FuelManager.FuelManagement.Repository.EquipmentRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class EquipmentAuthorizerImpl implements EquipmentAuthorizer{
    EquipmentRepo equipmentRepo;
    EquipmentAuthorizerImpl(EquipmentRepo equipmentRepo) {
        this.equipmentRepo = equipmentRepo;
    }
    @Override
    public boolean authorizeEquipment(String equipmentID) {
        Optional<Equipment> equipment = equipmentRepo.findById(equipmentID.toUpperCase());
        return equipment.isPresent();
    }
}
