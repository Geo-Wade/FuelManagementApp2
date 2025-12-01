package com.FuelManager.FuelManagement.Services;

import com.FuelManager.FuelManagement.Model.Transaction;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface TransactionManager {
    void addActiveTransaction(Transaction transaction);
    Transaction getActiveTransaction(int fuelingPosition);
    void finalizeActiveTransaction(int fuelingPosition);
}
