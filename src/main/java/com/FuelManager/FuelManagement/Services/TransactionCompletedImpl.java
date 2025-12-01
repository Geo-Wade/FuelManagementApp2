package com.FuelManager.FuelManagement.Services;

import com.FuelManager.FuelManagement.Model.Transaction;
import com.FuelManager.FuelManagement.Repository.TransactionRepo;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TransactionCompletedImpl implements TransactionCompleted {
    TransactionRepo transactionRepo;
    TransactionManager transactionManager;
    TransactionCompletedImpl(TransactionRepo transactionRepo, TransactionManager transactionManager) {
        this.transactionRepo = transactionRepo;
        this.transactionManager = transactionManager;
    }
    public void completeAndSaveTransaction(int fuelingPosition, double amountFueled) {
        transactionManager.getActiveTransaction(fuelingPosition).setAmountFueled(amountFueled);
        transactionManager.finalizeActiveTransaction(fuelingPosition);
    }
}
