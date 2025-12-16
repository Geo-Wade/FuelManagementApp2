package com.fuel.manager.dao.repositories;

import com.fuel.manager.dao.model.tables.authrorized.operator.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorRepo extends JpaRepository<Operator, String> {
}
