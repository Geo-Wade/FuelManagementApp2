package com.fuel.manager.services.transaction.builder;

import com.fuel.manager.dao.model.tables.transaction.ActiveTransaction;
import com.fuel.manager.dao.model.tables.transaction.StartupTransaction;
import com.fuel.manager.dao.model.tables.transaction.Transaction;
import com.fuel.manager.dao.repositories.ActiveTransactionRepo;
import com.fuel.manager.dao.repositories.StartupTransactionRepo;
import com.fuel.manager.dao.repositories.TransactionRepo;
import org.springframework.stereotype.Service;

@Service
public class TransactionBuilderImpl implements TransactionBuilder {
    StartupTransactionRepo startupTransactionRepo;
    TransactionRepo transactionRepo;
    ActiveTransactionRepo activeTransactionRepo;
    TransactionBuilderImpl(StartupTransactionRepo startupTransactionRepo,
                           TransactionRepo transactionRepo,
                           ActiveTransactionRepo activeTransactionRepo) {
        this.startupTransactionRepo = startupTransactionRepo;
        this.transactionRepo = transactionRepo;
        this.activeTransactionRepo = activeTransactionRepo;
    }
    public void initializeTransaction(int trId) {
        StartupTransaction startupTransaction = startupTransactionRepo.findById(trId).orElseThrow();
        Transaction transaction = buildNewTransaction(startupTransaction);
        ActiveTransaction activeTransaction = new ActiveTransaction();
        activeTransaction.setFuelingPosition(startupTransaction.getFuelingPosition());
        activeTransaction.setTransaction(transaction);
        startupTransaction.setDidAuthorize(true);
        startupTransactionRepo.save(startupTransaction);
        activeTransactionRepo.save(activeTransaction);

    }

    Transaction buildNewTransaction(StartupTransaction startupTransaction) {
        Transaction transaction =  new Transaction();
        transaction.setFuelingPosition(startupTransaction.getFuelingPosition());
        transaction.setOperator(startupTransaction.getOperatorId());
        transaction.setEquipment(startupTransaction.getEquipmentId());
        transactionRepo.save(transaction);
        return  transaction;
    }
}
