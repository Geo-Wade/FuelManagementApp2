package com.FuelManager.FuelManagement.Services;

import com.FuelManager.FuelManagement.Exceptions.AuthorizationFailedException;
import com.FuelManager.FuelManagement.Model.Equipment;
import com.FuelManager.FuelManagement.Model.Transaction;
import com.FuelManager.FuelManagement.Repository.EquipmentRepo;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class TransactionBuilderImpl implements TransactionBuilder{
    Transaction transaction;
    EquipmentRepo equipmentRepo;
    TransactionBuilderImpl(EquipmentRepo equipmentRepo) {
        this.equipmentRepo = equipmentRepo;
    }
    @Override
    public Transaction startTransaction() {
        transaction = new Transaction();
        return  transaction;
    }

    @Override
    public Transaction addOperator(String operatorID) {
        if(transaction == null) {
            startTransaction();
        }
        transaction.setOperatorID(operatorID);
        return transaction;
    }

    @Override
    public Transaction addEquipment(String equipmentID) throws AuthorizationFailedException {
        Equipment equipment;
        try {
            equipment = equipmentRepo.findById(equipmentID).orElseThrow();
        }
        catch (NoSuchElementException noSuchElementException) {
            throw new AuthorizationFailedException("Equipment Not Authorized");
        }
        if(transaction == null) {
            transaction = startTransaction();
        }
        transaction.setEquipment(equipment);
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

    public Transaction getTransaction() {
        return transaction;
    }

    @Override
    public void clearTransaction() {
        transaction = null;
    }
}
