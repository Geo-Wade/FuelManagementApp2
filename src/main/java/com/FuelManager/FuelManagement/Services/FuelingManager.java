package com.FuelManager.FuelManagement.Services;

import org.springframework.stereotype.Service;

@Service
public interface FuelingManager {
    void activateHose(int fuelingPositionId);

    void inactivateHose(int fuelingPositionId);
}
