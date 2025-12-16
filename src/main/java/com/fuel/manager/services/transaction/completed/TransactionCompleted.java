package com.fuel.manager.services.transaction.completed;


public interface TransactionCompleted {
    void completeAndSaveTransaction(int fuelingPosition, double amountFueled);

}
