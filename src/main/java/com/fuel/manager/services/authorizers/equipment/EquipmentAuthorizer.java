package com.fuel.manager.services.authorizers.equipment;

import com.fuel.manager.dao.model.tables.authrorized.equipment.Equipment;

public interface EquipmentAuthorizer {
    Equipment authorize(String equipmentId);
}
