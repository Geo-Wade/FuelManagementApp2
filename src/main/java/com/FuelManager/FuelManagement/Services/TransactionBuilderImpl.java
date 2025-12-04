package com.FuelManager.FuelManagement.Services;

import com.FuelManager.FuelManagement.Exceptions.AuthorizationFailedException;
import com.FuelManager.FuelManagement.Model.Equipment;
import com.FuelManager.FuelManagement.Model.Transaction;
import com.FuelManager.FuelManagement.Repository.EquipmentRepo;
import com.FuelManager.FuelManagement.Repository.OperatorRepo;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class TransactionBuilderImpl implements TransactionBuilder{
    Transaction transaction;
    EquipmentRepo equipmentRepo;
    OperatorRepo operatorRepo;
    TransactionBuilderImpl(EquipmentRepo equipmentRepo, OperatorRepo operatorRepo) {
        this.equipmentRepo = equipmentRepo;
        this.operatorRepo = operatorRepo;
    }
    @Override
    public Transaction startTransaction() {
        transaction = new Transaction();
        return  transaction;
    }

    @Override
    public Transaction addOperator(String operator) {
        if(transaction == null) {
            startTransaction();
        }
        try {
            transaction.setOperator(operatorRepo.findById(operator).orElseThrow());
            return transaction;
        } catch (NoSuchElementException noSuchElementException) {
            throw new AuthorizationFailedException("Operator Not Authorized");
        }
    }

    @Override
    public Transaction addEquipment(String equipmentID) throws AuthorizationFailedException {
        if(transaction == null) {
            transaction = startTransaction();
        }
        try {
            Equipment equipment = equipmentRepo.findById(equipmentID).orElseThrow();
            transaction.setEquipment(equipment);
        }
        catch (NoSuchElementException noSuchElementException) {
            throw new AuthorizationFailedException("Equipment Not Authorized");
        }
        return transaction;
    }

    @Override
    public Transaction addFuelingPosition(int fuelingPosition) {
        if(transaction == null) {
            transaction = startTransaction();
        }
        transaction.setFuelingPosition(fuelingPosition);
        return transaction;
    }

    public Transaction getTransaction()
    {
        if(transaction == null) {
            transaction = startTransaction();
        }
        return transaction;
    }

    @Override
    public void clearTransaction() {
        transaction = null;
    }
}
