package com.FuelManager.FuelManagement.Control;

import com.FuelManager.FuelManagement.Services.Authorization.EquipmentAuthorizer;
import com.FuelManager.FuelManagement.Services.TransactionBuilder;
import org.springframework.stereotype.Component;

@Component
public class EquipmentPrompt implements CLIControl{

    IOControl ioControl;
    EquipmentAuthorizer equipmentAuthorizer;
    OperatorPrompt operatorPrompt;
    TransactionBuilder transactionBuilder;
    EquipmentPrompt(IOControl ioControl, EquipmentAuthorizer equipmentAuthorizer,OperatorPrompt operatorPrompt, TransactionBuilder transactionBuilder) {
        this.ioControl = ioControl;
        this.equipmentAuthorizer = equipmentAuthorizer;
        this.transactionBuilder = transactionBuilder;
        this.operatorPrompt = operatorPrompt;
    }
    @Override
    public void execute() {
        String equipmentID = ioControl.stringHandler("Enter Equipment ID");
        if(equipmentAuthorizer.authorizeEquipment(equipmentID)) {
            transactionBuilder.addEquipment(equipmentID);
            operatorPrompt.execute();
        }
        else {
            ioControl.println("Invalid Equipment ID");
        }
    }
}
