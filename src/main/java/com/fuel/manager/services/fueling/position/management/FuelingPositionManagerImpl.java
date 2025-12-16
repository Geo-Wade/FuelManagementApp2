package com.fuel.manager.services.fueling.position.management;

import com.fuel.manager.dao.model.tables.accounted.Product;
import com.fuel.manager.dao.model.tables.transaction.ActiveTransaction;
import com.fuel.manager.dao.model.tables.controlled.fueling.FuelingPosition;
import com.fuel.manager.dao.model.tables.transaction.Transaction;
import com.fuel.manager.dao.repositories.ActiveTransactionRepo;
import com.fuel.manager.dao.repositories.StartupTransactionRepo;
import com.fuel.manager.dao.repositories.FuelingPositionRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
public class FuelingPositionManagerImpl implements FuelingPositionManager {

    FuelingPositionRepo fuelingPositionRepo;
    ActiveTransactionRepo activeTransactionRepo;
    StartupTransactionRepo startupTransactionRepo;

    FuelingPositionManagerImpl(FuelingPositionRepo fuelingPositionRepo, ActiveTransactionRepo activeTransactionRepo, StartupTransactionRepo startupTransactionRepo) {
        this.fuelingPositionRepo = fuelingPositionRepo;
        this.activeTransactionRepo = activeTransactionRepo;
        this.startupTransactionRepo = startupTransactionRepo;
    }

    @Override
    public List<Integer> getActiveFuelingPositionById() {
        return activeTransactionRepo.findAll().stream()
                .map(ActiveTransaction::getFuelingPosition)
                .toList();
    }

    @Override
    public List<Integer> getInactiveFuelingPositionById(int trId) {
        System.out.println();
        try {
            return fuelingPositionRepo
                    .findAll()
                    .stream()
                    .filter(pr -> startupTransactionRepo.findById(trId).orElseThrow().getEquipmentId().getProducts().stream()
                            .map(Product::getProductName)
                            .anyMatch(pr2 -> pr.getProduct().getProductName().equals(pr2)))
                    .map(FuelingPosition::getFuelingPositionNumber)
                    .filter(Predicate.not(hoseN -> activeTransactionRepo.findAll().stream()
                            .map(ActiveTransaction::getTransactions)
                            .map(Transaction::getFuelingPosition).anyMatch(x->x.equals(hoseN))))
                    .toList();

        } catch (Exception e) {
            System.out.println(e);
            return List.of();
        }
    }
}
