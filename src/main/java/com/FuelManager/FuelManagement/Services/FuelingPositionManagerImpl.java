package com.FuelManager.FuelManagement.Services;

import com.FuelManager.FuelManagement.Model.FuelingPosition;
import com.FuelManager.FuelManagement.Repository.FuelingPositionRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
public class FuelingPositionManagerImpl implements FuelingPositionManager{

    FuelingPositionRepo fuelingPositionRepo;
    TransactionManager transactionManager;

    FuelingPositionManagerImpl(FuelingPositionRepo fuelingPositionRepo, TransactionManager transactionManager) {
        this.fuelingPositionRepo = fuelingPositionRepo;
        this.transactionManager = transactionManager;
    }

    @Override
    public List<Integer> getActiveFuelingPositionById() {
        return fuelingPositionRepo.findAll().
                stream()
                .map(FuelingPosition::getFuelingPositionNumber)
                .filter(x -> transactionManager.hasActiveTransaction(x))
                .toList();
    }

    @Override
    public List<Integer> getInactiveFuelingPositionById() {
        return fuelingPositionRepo.findAll().
                stream()
                .map(FuelingPosition::getFuelingPositionNumber)
                .filter(Predicate.not(x -> transactionManager.hasActiveTransaction(x)))
                .toList();
    }
}
