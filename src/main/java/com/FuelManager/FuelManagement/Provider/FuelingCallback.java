package com.FuelManager.FuelManagement.Provider;

public interface FuelingCallback {
    void completedTransaction(int hoseNumber, float amount);
}
