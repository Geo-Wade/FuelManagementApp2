package com.fuel.manager.services.transaction.completed;

import com.fuel.manager.dao.model.tables.transaction.ActiveTransaction;
import com.fuel.manager.dao.model.tables.transaction.Transaction;
import com.fuel.manager.dao.repositories.ActiveTransactionRepo;
import com.fuel.manager.dao.repositories.TransactionRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransactionCompletedImpl implements TransactionCompleted {
    TransactionRepo transactionRepo;
    ActiveTransactionRepo activeTransactionRepo;
    TransactionCompletedImpl(TransactionRepo transactionRepo, ActiveTransactionRepo activeTransactionRepo) {
        this.transactionRepo = transactionRepo;
        this.activeTransactionRepo = activeTransactionRepo;
    }

    public void completeAndSaveTransaction(int fuelingPosition, double amountFueled) {
        ActiveTransaction activeTransaction = activeTransactionRepo.findById(fuelingPosition).orElseThrow();
        Transaction transaction = activeTransaction.getTransactions();
        transaction.setAmountFueled(amountFueled);
        transaction.setTransactionTime(LocalDateTime.now());
        transactionRepo.save(transaction);
        activeTransactionRepo.delete(activeTransaction);
    }
}
