package com.FuelManager.FuelManagement.Provider;

import com.FuelManager.FuelManagement.Services.TransactionCompleted;
import org.springframework.stereotype.Component;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class ExternalFuelTaskManagerImpl implements ExternalFuelTaskManager {
    ConcurrentHashMap<Integer, ExternalFuelingTask> fuelingTasks= new ConcurrentHashMap<Integer, ExternalFuelingTask>();
    ExecutorService executor = Executors.newFixedThreadPool(8);
    TransactionCompleted transactionCompleted;

    ExternalFuelTaskManagerImpl(TransactionCompleted transactionCompleted) {
        this.transactionCompleted = transactionCompleted;
    }
    public void startFueling(int fuelingPosition) {
        ExternalFuelingTask externalFuelingTask = new ExternalFuelingTaskImpl();
        executor.submit(externalFuelingTask);
        System.out.println(externalFuelingTask);
        fuelingTasks.put(fuelingPosition, externalFuelingTask);
    }

    public void stopFueling(int fuelingPosition) {

        transactionCompleted.completeAndSaveTransaction(fuelingPosition, fuelingTasks.remove(fuelingPosition).stopAndGetTotal());
    }
}
