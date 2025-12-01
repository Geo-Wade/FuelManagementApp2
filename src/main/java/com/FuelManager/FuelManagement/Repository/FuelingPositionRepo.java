package com.FuelManager.FuelManagement.Repository;

import com.FuelManager.FuelManagement.Model.FuelingPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelingPositionRepo extends JpaRepository<FuelingPosition, Integer> {
}
