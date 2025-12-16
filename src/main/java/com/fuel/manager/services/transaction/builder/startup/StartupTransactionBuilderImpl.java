package com.fuel.manager.services.transaction.builder.startup;

import com.fuel.manager.dao.model.tables.transaction.StartupTransaction;
import com.fuel.manager.dao.repositories.EquipmentRepo;
import com.fuel.manager.dao.repositories.FuelingPositionRepo;
import com.fuel.manager.dao.repositories.OperatorRepo;
import com.fuel.manager.dao.repositories.StartupTransactionRepo;
import com.fuel.manager.exceptions.AuthorizationFailedException;
import com.fuel.manager.services.authorizers.equipment.EquipmentAuthorizer;
import com.fuel.manager.services.authorizers.operator.OperatorAuthorizer;
import com.fuel.manager.services.transaction.builder.TransactionBuilder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
@Service
public class StartupTransactionBuilderImpl implements StartupTransactionBuilder{
    StartupTransactionRepo startupTransactionRepo;
    FuelingPositionRepo fuelingPositionRepo;
    TransactionBuilder transactionBuilder;
    EquipmentAuthorizer equipmentAuthorizer;
    OperatorAuthorizer operatorAuthorizer;
    StartupTransactionBuilderImpl(StartupTransactionRepo startupTransactionRepo,
                                  OperatorRepo operatorRepo,
                                  EquipmentRepo equipmentRepo,
                                  FuelingPositionRepo fuelingPositionRepo,
                                  TransactionBuilder transactionBuilder,
                                  EquipmentAuthorizer equipmentAuthorizer,
                                  OperatorAuthorizer operatorAuthorizer) {
        this.startupTransactionRepo = startupTransactionRepo;
        this.fuelingPositionRepo = fuelingPositionRepo;
        this.transactionBuilder = transactionBuilder;
        this.equipmentAuthorizer = equipmentAuthorizer;
        this.operatorAuthorizer = operatorAuthorizer;
    }
    @Override
    public int startBuildingTransaction() {
        StartupTransaction startupTransaction = new StartupTransaction();
        startupTransactionRepo.save(startupTransaction);
        System.out.println(startupTransaction.getTransactionID());
        return startupTransaction.getTransactionID();
    }

    @Override
    public void addEquipment(int tr, String eq)  throws  AuthorizationFailedException {
        StartupTransaction startupTransaction = getRepo(tr);
        startupTransaction.setEquipmentId(equipmentAuthorizer.authorize(eq));
        startupTransactionRepo.save(startupTransaction);
    }

    @Override
    public void addOperator(int tr, String op)  throws  AuthorizationFailedException{
        StartupTransaction startupTransaction = getRepo(tr);
        startupTransaction.setOperatorId(operatorAuthorizer.authorize(op));
        startupTransactionRepo.save(startupTransaction);
    }

    @Override
    public void setFuelingPosition(int tr, int hn)  throws  AuthorizationFailedException {
        StartupTransaction startupTransaction = getRepo(tr);
        startupTransaction.setFuelingPosition(hn);
        startupTransactionRepo.save(startupTransaction);
    }

    public void buildTransactionFromStartupTransaction(int trId) {
        transactionBuilder.initializeTransaction(trId);
    }

    StartupTransaction getRepo(int trId) throws  AuthorizationFailedException {
        try {
            return startupTransactionRepo.findById(trId).orElseThrow();
        } catch (NoSuchElementException noSuchElementException) {
            throw new AuthorizationFailedException("Unable to locate transaction " + trId);
        }
    }
}
