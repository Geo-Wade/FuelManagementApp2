package com.FuelManager.FuelManagement.Control;

import com.FuelManager.FuelManagement.Exceptions.AuthorizationFailedException;
import com.FuelManager.FuelManagement.Exceptions.InvalidInputException;
import com.FuelManager.FuelManagement.Services.FuelingManager;
import org.springframework.stereotype.Component;

@Component
public class StartStopFuelingControl implements CLIControl {

    IOControl outputControl;
    FuelingManager fuelingManager;
    InactiveHoseSelection inactiveHoseSelection;
    EquipmentPrompt equipmentPrompt;

    public StartStopFuelingControl(IOControl outputControl, FuelingManager fuelingManager, EquipmentPrompt equipmentPrompt, InactiveHoseSelection inactiveHoseSelection) {
        this.outputControl = outputControl;
        this.equipmentPrompt = equipmentPrompt;
        this.fuelingManager = fuelingManager;
        this.inactiveHoseSelection = inactiveHoseSelection;
    }

    @Override
    public void execute() {
        int response;
        try {
            response = outputControl.intHandler("1) Start Fueling\t2) Stop Fueling");
            if(response == 1) {
                equipmentPrompt.execute();
            } else if(response == 2) {
                inactiveHoseSelection.execute();
            }
        } catch (InvalidInputException e) {
            e.printStackTrace();
        } catch (AuthorizationFailedException e) {
            throw new AuthorizationFailedException("Failed to Authorize");
        }
    }
}
