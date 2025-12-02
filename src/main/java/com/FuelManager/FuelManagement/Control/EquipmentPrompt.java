package com.FuelManager.FuelManagement.Control;

import com.FuelManager.FuelManagement.Services.EquipmentAuthorizer;
import com.FuelManager.FuelManagement.Services.TransactionBuilder;
import org.springframework.stereotype.Component;

@Component
public class EquipmentPrompt implements CLIControl{

    ActiveHoseSelection activeHoseSelection;
    IOControl ioControl;
    EquipmentAuthorizer equipmentAuthorizer;
    TransactionBuilder transactionBuilder;
    EquipmentPrompt(IOControl ioControl, EquipmentAuthorizer equipmentAuthorizer, ActiveHoseSelection activeHoseSelection, TransactionBuilder transactionBuilder) {
        this.ioControl = ioControl;
        this.equipmentAuthorizer = equipmentAuthorizer;
        this.activeHoseSelection = activeHoseSelection;
        this.transactionBuilder = transactionBuilder;
    }
    @Override
    public void execute() {
        String equipmentID = ioControl.stringHandler("Enter Equipment ID");
        if(equipmentAuthorizer.authorizeEquipment(equipmentID)) {
            transactionBuilder.addEquipment(equipmentID);
            activeHoseSelection.execute();
        }
    }
}
