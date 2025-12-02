package com.FuelManager.FuelManagement.Services;

import com.FuelManager.FuelManagement.Model.Transaction;
import org.springframework.stereotype.Service;

@Service
public class TransactionBuilderImpl implements TransactionBuilder{
    Transaction transaction;
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
    public Transaction addEquipment(String equipmentID) {
        if(transaction == null) {
            transaction = startTransaction();
        }
        transaction.setEquipmentID(equipmentID);
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

    @Override
    public void clearTransaction() {
        transaction = null;
    }
}
