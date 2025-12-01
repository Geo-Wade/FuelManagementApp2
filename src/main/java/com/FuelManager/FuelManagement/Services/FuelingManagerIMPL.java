package com.FuelManager.FuelManagement.Services;

import com.FuelManager.FuelManagement.Model.Transaction;
import com.FuelManager.FuelManagement.Provider.ExternalFuelTaskManager;
import org.springframework.stereotype.Component;

@Component
public class FuelingManagerIMPL implements FuelingManager {

    ExternalFuelTaskManager externalFuelingTaskManager;
    FuelingAuthorizer fuelingAuthorizer;
    TransactionManager transactionManager;
    FuelingManagerIMPL(ExternalFuelTaskManager externalFuelingTaskManager, FuelingAuthorizer fuelingAuthorizer, TransactionManager transactionManager) {
        this.externalFuelingTaskManager = externalFuelingTaskManager;
        this.fuelingAuthorizer = fuelingAuthorizer;
        this.transactionManager = transactionManager;
    }
    public void startFueling() {
        Transaction transaction = new Transaction();
        transaction.setFuelingPosition(fuelingAuthorizer.authorizeFuelingPosition().getFuelingPositionNumber());
        transactionManager.addActiveTransaction(transaction);
        externalFuelingTaskManager.startFueling(transaction.getFuelingPosition());
    }
    public void stopFueling(int fuelingPosition) {
        externalFuelingTaskManager.stopFueling(fuelingPosition);
    }
}
