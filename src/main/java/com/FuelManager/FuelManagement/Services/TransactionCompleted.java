package com.FuelManager.FuelManagement.Services;

import org.springframework.stereotype.Component;

@Component
public interface TransactionCompleted {
    public void completeAndSaveTransaction(int fuelingPosition, double amountFueled);

}
