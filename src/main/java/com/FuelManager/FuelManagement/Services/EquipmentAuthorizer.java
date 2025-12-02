package com.FuelManager.FuelManagement.Services;

import org.springframework.stereotype.Service;

@Service
public interface EquipmentAuthorizer {
    boolean authorizeEquipment(String equipmentID);
}
