package com.FuelManager.FuelManagement.Services;

import com.FuelManager.FuelManagement.Model.Transaction;
import com.FuelManager.FuelManagement.Repository.TransactionRepo;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class TransactionManagerImpl implements TransactionManager{
    final private ConcurrentHashMap<Integer, Transaction> activeTransactions = new ConcurrentHashMap<>();
    TransactionRepo transactionRepo;

    TransactionManagerImpl(TransactionRepo transactionRepo) {
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

    @Override
    public boolean hasActiveTransaction(int fuelingPosition) {
        return activeTransactions.containsKey(fuelingPosition);
    }
}
