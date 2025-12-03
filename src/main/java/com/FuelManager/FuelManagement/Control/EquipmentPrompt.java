package com.FuelManager.FuelManagement.Control;

import com.FuelManager.FuelManagement.Exceptions.AuthorizationFailedException;
import com.FuelManager.FuelManagement.Repository.EquipmentRepo;
import com.FuelManager.FuelManagement.Services.Authorization.EquipmentAuthorizer;
import com.FuelManager.FuelManagement.Services.TransactionBuilder;
import org.springframework.stereotype.Component;

@Component
public class EquipmentPrompt implements CLIControl{

    IOControl ioControl;
    OperatorPrompt operatorPrompt;
    TransactionBuilder transactionBuilder;
    EquipmentRepo equipmentRepo;
    EquipmentPrompt(IOControl ioControl,
                    OperatorPrompt operatorPrompt,
                    TransactionBuilder transactionBuilder,
                    EquipmentRepo equipmentRepo) {
        this.ioControl = ioControl;
        this.transactionBuilder = transactionBuilder;
        this.operatorPrompt = operatorPrompt;
        this.equipmentRepo = equipmentRepo;
    }
    @Override
    public void execute() {
        String equipmentID = ioControl.stringHandler("Enter Equipment ID");
        try {
            transactionBuilder.addEquipment(equipmentID);
            operatorPrompt.execute();
        }catch (AuthorizationFailedException authorizationFailedException) {
            ioControl.println("Transaction Failed");
        }
    }
}
