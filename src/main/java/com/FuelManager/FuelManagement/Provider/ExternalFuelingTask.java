package com.FuelManager.FuelManagement.Provider;

import org.springframework.stereotype.Component;

@Component
public interface ExternalFuelingTask extends Runnable {
    double stopAndGetTotal();
}
