package com.fuel.manager.dao.repositories;

import com.fuel.manager.dao.model.tables.transaction.StartupTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StartupTransactionRepo extends JpaRepository<StartupTransaction, Integer> {
}
