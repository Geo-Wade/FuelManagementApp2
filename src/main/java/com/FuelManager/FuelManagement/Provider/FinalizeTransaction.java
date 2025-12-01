package com.FuelManager.FuelManagement.Provider;

import org.springframework.stereotype.Component;

@Component
public interface FinalizeTransaction {
    void completeTransaction (int fuelingPosition, double amount);
}
