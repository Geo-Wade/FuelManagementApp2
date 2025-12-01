package com.FuelManager.FuelManagement.Provider;

import org.springframework.stereotype.Component;

@Component
public interface ExternalFuelTaskManager {
    void startFueling(int fuelingPosition);
    void stopFueling(int fuelingPositions);
}
