package com.FuelManager.FuelManagement.Services;

import com.FuelManager.FuelManagement.Repository.TransactionRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransactionCompletedImpl implements TransactionCompleted {
    TransactionRepo transactionRepo;
    TransactionManager transactionManager;

    TransactionCompletedImpl(TransactionRepo transactionRepo, TransactionManager transactionManager) {
        this.transactionRepo = transactionRepo;
        this.transactionManager = transactionManager;
    }

    public void completeAndSaveTransaction(int fuelingPosition, double amountFueled) {
        System.out.println(transactionManager.getActiveTransaction(fuelingPosition));
        transactionManager.getActiveTransaction(fuelingPosition).setAmountFueled(amountFueled);
        transactionManager.getActiveTransaction(fuelingPosition).setTransactionTime(LocalDateTime.now());
        transactionManager.finalizeActiveTransaction(fuelingPosition);
    }
}
