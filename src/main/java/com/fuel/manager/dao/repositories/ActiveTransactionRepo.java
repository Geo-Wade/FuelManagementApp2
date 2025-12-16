package com.fuel.manager.dao.repositories;

import com.fuel.manager.dao.model.tables.transaction.ActiveTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActiveTransactionRepo extends JpaRepository<ActiveTransaction, Integer> {

}
