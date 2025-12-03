package com.FuelManager.FuelManagement.Services;

import com.FuelManager.FuelManagement.Model.FuelingPosition;
import com.FuelManager.FuelManagement.Model.Product;
import com.FuelManager.FuelManagement.Repository.FuelingPositionRepo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FuelingPositionManagerImpl implements FuelingPositionManager{

    FuelingPositionRepo fuelingPositionRepo;
    TransactionManager transactionManager;
    TransactionBuilder transactionBuilder;

    FuelingPositionManagerImpl(FuelingPositionRepo fuelingPositionRepo, TransactionManager transactionManager, TransactionBuilder transactionBuilder) {
        this.fuelingPositionRepo = fuelingPositionRepo;
        this.transactionManager = transactionManager;
        this.transactionBuilder = transactionBuilder;
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
        /*return fuelingPositionRepo.findAll().
                stream()
                .map(FuelingPosition::getFuelingPositionNumber)
                .filter(Predicate.not(x -> transactionManager.hasActiveTransaction(x)))
                .toList();*/
        return fuelingPositionRepo.findAll()
                .stream()
                .filter(fp1 -> transactionBuilder
                        .getTransaction()
                        .getEquipment()
                        .getProducts()
                        .stream()
                        .map(Product::getProductName)
                        .anyMatch(fp2 -> fp2.equals(fp1.getProduct().getProductName())))
                .map(FuelingPosition::getFuelingPositionNumber)
                .toList();
    }
}
