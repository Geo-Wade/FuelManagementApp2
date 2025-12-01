package com.FuelManager.FuelManagement.Services;

import com.FuelManager.FuelManagement.Model.Equipment;
import com.FuelManager.FuelManagement.Model.FuelingPosition;
import com.FuelManager.FuelManagement.Model.Operator;
import org.springframework.stereotype.Service;

@Service
public interface FuelingAuthorizer {
    FuelingPosition authorizeFuelingPosition();
    Equipment authorizeEquipmentID();
    Operator authorizeOperatorID();
}
