package com.FuelManager.FuelManagement.Services;

import org.springframework.stereotype.Component;

@Component
public interface FuelingManager {
    void startFueling();
    void stopFueling(int fuelingPosition);
}
