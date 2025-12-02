package com.FuelManager.FuelManagement.Services;

import com.FuelManager.FuelManagement.Model.Transaction;
import org.springframework.stereotype.Service;

@Service
public interface TransactionBuilder {
    Transaction startTransaction();
    Transaction addOperator(String OperatorID);
    Transaction addEquipment(String EquipmentID);
    Transaction addFuelingPosition(int fuelingPositionID);
    void clearTransaction();
}
