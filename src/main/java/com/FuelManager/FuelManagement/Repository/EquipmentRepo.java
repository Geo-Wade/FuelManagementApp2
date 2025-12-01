package com.FuelManager.FuelManagement.Repository;

import com.FuelManager.FuelManagement.Model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepo extends JpaRepository<Equipment, String> {
}
