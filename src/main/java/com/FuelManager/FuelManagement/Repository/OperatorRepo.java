package com.FuelManager.FuelManagement.Repository;

import com.FuelManager.FuelManagement.Model.Operator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperatorRepo extends JpaRepository<Operator, String> {
}
