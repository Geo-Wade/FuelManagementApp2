package com.FuelManager.FuelManagement.Services;

import com.FuelManager.FuelManagement.Provider.ExternalFuelTaskManager;
import org.springframework.stereotype.Service;

@Service
public class FuelingManagerImpl implements FuelingManager {

    ExternalFuelTaskManager externalFuelingTaskManager;
    TransactionManager transactionManager;

    FuelingManagerImpl(ExternalFuelTaskManager externalFuelingTaskManager, TransactionManager transactionManager) {
        this.externalFuelingTaskManager = externalFuelingTaskManager;
        this.transactionManager = transactionManager;
    }

    public void activateHose(int fuelingPositionId) {

        externalFuelingTaskManager.startFueling(fuelingPositionId);
    }

    public void inactivateHose(int fuelingPositionId) {
        externalFuelingTaskManager.stopFueling(fuelingPositionId);
    }
}
