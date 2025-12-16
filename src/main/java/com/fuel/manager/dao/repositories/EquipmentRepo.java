package com.fuel.manager.dao.repositories;

import com.fuel.manager.dao.model.tables.authrorized.equipment.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepo extends JpaRepository<Equipment, String> {
}
