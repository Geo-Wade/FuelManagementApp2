package com.fuel.manager.Control.cli.start;

import com.fuel.manager.Control.cli.prompt.hose.selection.ActiveHoseSelection;
import com.fuel.manager.Control.cli.prompt.id.EquipmentPrompt;
import com.fuel.manager.Control.cli.utilities.IOControl;
import com.fuel.manager.exceptions.AuthorizationFailedException;
import com.fuel.manager.exceptions.InvalidInputException;
import com.fuel.manager.services.fueling.management.FuelingManager;
import com.fuel.manager.services.transaction.builder.startup.StartupTransactionBuilder;
import org.springframework.stereotype.Component;

@Component
public class StartStopFuelingControl {

    IOControl outputControl;
    ActiveHoseSelection activeHoseSelection;
    EquipmentPrompt equipmentPrompt;
    StartupTransactionBuilder startupTransactionBuilder;

    public StartStopFuelingControl(IOControl outputControl,
                                   EquipmentPrompt equipmentPrompt,
                                   ActiveHoseSelection activeHoseSelection,
                                   StartupTransactionBuilder startupTransactionBuilder) {
        this.outputControl = outputControl;
        this.equipmentPrompt = equipmentPrompt;
        this.activeHoseSelection = activeHoseSelection;
        this.startupTransactionBuilder = startupTransactionBuilder;
    }

    public void start() {
        int response;
        boolean exitResponse = false;
        while (!exitResponse)
            try {
                response = outputControl.intHandler("1) Start Fueling\t2) Stop Fueling\t3) Exit");
                if (response == 1) {
                    int trID = startupTransactionBuilder.startBuildingTransaction();
                    equipmentPrompt.execute(trID);
                } else if (response == 2) {
                    activeHoseSelection.execute(0);
                } else if (response == 3) {
                    exitResponse = true;
                }
            } catch (InvalidInputException e) {
                e.printStackTrace();
            } catch (AuthorizationFailedException e) {
                System.out.println("Unauthorized");
            }
    }
}

