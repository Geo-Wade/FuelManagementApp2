package com.FuelManager.FuelManagement.Provider;

import org.springframework.stereotype.Component;

@Component
public interface ExternalFuelTaskManager {
    public void startFueling(int fuelingPosition);
    public void stopFueling(int fuelingPositions);
}
