package com.FuelManager.FuelManagement.Provider;

import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Component
public class ExternalFuelingTaskImpl implements ExternalFuelingTask {

    CompletableFuture<Double> amount = new CompletableFuture<>();
    int fuelingPosition;
    double gallonsPerTick = 0.1;
    boolean stopSignal = false;

    @Override
    public void run() {

        long startTime = System.currentTimeMillis();
        while (!stopSignal) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        long endTime = System.currentTimeMillis();
        amount.complete((endTime - startTime) / 1000.0);
    }

    public void setFuelingPosition(int fuelingPosition) {
        this.fuelingPosition = fuelingPosition;
    }

    public double stopAndGetTotal() {
        stopSignal = true;
        try {
            return amount.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "ExternalFuelingTaskImpl{" +
                "amount=" + amount +
                ", fuelingPosition=" + fuelingPosition +
                ", gallonsPerTick=" + gallonsPerTick +
                ", stopSignal=" + stopSignal +
                '}';
    }
}
