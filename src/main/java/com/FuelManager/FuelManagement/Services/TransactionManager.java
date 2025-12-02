package com.FuelManager.FuelManagement.Services;

import com.FuelManager.FuelManagement.Model.Transaction;
import org.springframework.stereotype.Service;

@Service
public interface TransactionManager {
    void addActiveTransaction(Transaction transaction);
    Transaction getActiveTransaction(int fuelingPosition);
    void finalizeActiveTransaction(int fuelingPosition);
    boolean hasActiveTransaction(int fuelingPosition);
}
