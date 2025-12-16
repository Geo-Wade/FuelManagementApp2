package com.fuel.manager.dao.repositories;

import com.fuel.manager.dao.model.tables.controlled.fueling.FuelingPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelingPositionRepo extends JpaRepository<FuelingPosition, Integer> {
}
