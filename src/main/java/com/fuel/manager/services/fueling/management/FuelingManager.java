package com.fuel.manager.services.fueling.management;

public interface FuelingManager {
    void activateHose(int fuelingPositionId);

    void inactivateHose(int fuelingPositionId);
}
