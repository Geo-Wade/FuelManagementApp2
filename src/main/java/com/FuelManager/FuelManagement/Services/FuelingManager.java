package com.FuelManager.FuelManagement.Services;

import org.springframework.stereotype.Service;

@Service
public interface FuelingManager {
    void startFueling(int fuelingPosition);
    void stopFueling(int fuelingPosition);
}
