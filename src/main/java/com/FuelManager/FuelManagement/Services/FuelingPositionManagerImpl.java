package com.FuelManager.FuelManagement.Services;

import com.FuelManager.FuelManagement.Model.FuelingPosition;
import com.FuelManager.FuelManagement.Model.Product;
import com.FuelManager.FuelManagement.Repository.FuelingPositionRepo;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.function.Predicate;

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
        try {
            return fuelingPositionRepo.findAll()
                    .stream()
                    .filter(fp -> transactionBuilder
                            .getTransaction()
                            .getEquipment()
                            .getProducts()
                            .stream()
                            .map(Product::getProductName)
                            .anyMatch(x -> x.equals(fp.getProduct().getProductName())))
                    .map(FuelingPosition::getFuelingPositionNumber)
                    .filter(Predicate.not(x -> transactionManager.hasActiveTransaction(x)))
                    .toList();
        } catch (Exception e) {
            return List.of();
        }
    }
}
