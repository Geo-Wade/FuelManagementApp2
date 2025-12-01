package com.FuelManager.FuelManagement.Provider;

import org.springframework.stereotype.Component;

@Component
public class FinalizeTransactionImpl implements FinalizeTransaction{
    public void completeTransaction (int fuelingPosition, double amount) {
        System.out.println("Fueled " + amount + " gallons at position " + fuelingPosition);
    }
}
