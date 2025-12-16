package com.fuel.manager.Control.cli.prompt.id;

import com.fuel.manager.Control.cli.utilities.CLIControl;
import com.fuel.manager.Control.cli.utilities.IOControl;
import com.fuel.manager.exceptions.AuthorizationFailedException;
import com.fuel.manager.services.authorizers.equipment.EquipmentAuthorizer;
import com.fuel.manager.services.transaction.builder.startup.StartupTransactionBuilder;
import org.springframework.stereotype.Component;

@Component
public class EquipmentPrompt implements CLIControl {

    IOControl ioControl;
    OperatorPrompt operatorPrompt;
    EquipmentAuthorizer equipmentAuthorizer;
    StartupTransactionBuilder startupTransactionBuilder;

    EquipmentPrompt(IOControl ioControl,
                    OperatorPrompt operatorPrompt,
                    StartupTransactionBuilder startupTransactionBuilder,
                    EquipmentAuthorizer equipmentAuthorizer) {
        this.ioControl = ioControl;
        this.operatorPrompt = operatorPrompt;
        this.startupTransactionBuilder = startupTransactionBuilder;
        this.equipmentAuthorizer = equipmentAuthorizer;
    }

    @Override
    public void execute(int trID) {
        try {
            startupTransactionBuilder.addEquipment(trID, ioControl.stringHandler("Enter equipment ID"));
            operatorPrompt.execute(trID);
        } catch (AuthorizationFailedException authorizationFailedException) {
            ioControl.println("Transaction Failed");
        }
    }
}
