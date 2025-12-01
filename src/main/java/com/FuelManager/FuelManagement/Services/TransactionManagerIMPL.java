package com.FuelManager.FuelManagement.Services;

import com.FuelManager.FuelManagement.Model.Transaction;
import com.FuelManager.FuelManagement.Repository.TransactionRepo;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class TransactionManagerIMPL implements TransactionManager{
    final private ConcurrentHashMap<Integer, Transaction> activeTransactions = new ConcurrentHashMap<>();
    TransactionRepo transactionRepo;

    TransactionManagerIMPL(TransactionRepo transactionRepo) {
        this.transactionRepo = transactionRepo;
    }

    public void addActiveTransaction (Transaction transaction) {
        activeTransactions.put(transaction.getFuelingPosition(), transaction);
    }

    public Transaction getActiveTransaction(int fuelingPosition) {
        return activeTransactions.get(fuelingPosition);
    }
    public void finalizeActiveTransaction(int fuelingPosition) {
        transactionRepo.save(activeTransactions.remove(fuelingPosition));
    }
}
