package com.fuel.manager.services.fueling.management;

import com.fuel.manager.dao.repositories.ActiveTransactionRepo;
import com.fuel.manager.provider.ExternalFuelTaskManager;
import org.springframework.stereotype.Service;

@Service
public class FuelingManagerImpl implements FuelingManager {

    ExternalFuelTaskManager externalFuelingTaskManager;
    ActiveTransactionRepo activeTransactionRepo;

    FuelingManagerImpl(ExternalFuelTaskManager externalFuelingTaskManager, ActiveTransactionRepo activeTransactionRepo) {
        this.externalFuelingTaskManager = externalFuelingTaskManager;
        this.activeTransactionRepo = activeTransactionRepo;
    }

    public void activateHose(int fuelingPositionId) {
        externalFuelingTaskManager.startFueling(fuelingPositionId);
    }

    public void inactivateHose(int fuelingPositionId) {
        externalFuelingTaskManager.stopFueling(fuelingPositionId);
    }
}
