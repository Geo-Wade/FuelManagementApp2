package com.FuelManager.FuelManagement.Services;

import org.springframework.stereotype.Service;

@Service
public interface TransactionCompleted {
    void completeAndSaveTransaction(int fuelingPosition, double amountFueled);

}
