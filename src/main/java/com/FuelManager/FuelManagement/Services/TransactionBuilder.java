package com.FuelManager.FuelManagement.Services;

import com.FuelManager.FuelManagement.Model.Transaction;
import org.springframework.stereotype.Service;

@Service
public interface TransactionBuilder {
    Transaction startTransaction();

    Transaction addOperator(String operator);

    Transaction addEquipment(String EquipmentID);

    Transaction addFuelingPosition(int fuelingPositionID);

    Transaction getTransaction();

    void clearTransaction();
}
