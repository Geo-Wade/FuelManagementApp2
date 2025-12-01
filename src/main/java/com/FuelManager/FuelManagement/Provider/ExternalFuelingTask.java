package com.FuelManager.FuelManagement.Provider;

import org.springframework.stereotype.Component;

@Component
public interface ExternalFuelingTask extends Runnable {
    public double stopAndGetTotal();
}
