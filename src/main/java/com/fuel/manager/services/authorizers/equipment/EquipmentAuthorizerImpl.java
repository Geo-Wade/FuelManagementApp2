package com.fuel.manager.services.authorizers.equipment;

import com.fuel.manager.exceptions.AuthorizationFailedException;
import com.fuel.manager.dao.model.tables.authrorized.equipment.Equipment;
import com.fuel.manager.dao.repositories.EquipmentRepo;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class EquipmentAuthorizerImpl implements EquipmentAuthorizer{
    EquipmentRepo equipmentRepo;
    EquipmentAuthorizerImpl(EquipmentRepo equipmentRepo) {
        this.equipmentRepo = equipmentRepo;
    }
    @Override
    public Equipment authorize(String equipmentId) throws AuthorizationFailedException {
        try {
            return equipmentRepo.findById(equipmentId).orElseThrow();
        } catch (NoSuchElementException noSuchElementException) {
            throw new AuthorizationFailedException("Invalid equipment entered");
        }
    }
}
