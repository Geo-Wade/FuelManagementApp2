package com.FuelManager.FuelManagement.Control;

import com.FuelManager.FuelManagement.Exceptions.AuthorizationFailedException;
import com.FuelManager.FuelManagement.Exceptions.InvalidInputException;
import com.FuelManager.FuelManagement.Services.FuelingManager;
import org.springframework.stereotype.Component;

@Component
public class StartStopFuelingControl implements CLIControl {

    IOControl outputControl;
    FuelingManager fuelingManager;
    ActiveHoseSelection activeHoseSelection;
    EquipmentPrompt equipmentPrompt;

    public StartStopFuelingControl(IOControl outputControl, FuelingManager fuelingManager, EquipmentPrompt equipmentPrompt, ActiveHoseSelection activeHoseSelection) {
        this.outputControl = outputControl;
        this.equipmentPrompt = equipmentPrompt;
        this.fuelingManager = fuelingManager;
        this.activeHoseSelection = activeHoseSelection;
    }

    @Override
    public void execute() {
        int response;
        try {
            response = outputControl.intHandler("1) Start Fueling\t2) Stop Fueling");
            if(response == 1) {
                equipmentPrompt.execute();
            } else if(response == 2) {
                activeHoseSelection.execute();
            }
        } catch (InvalidInputException e) {
            e.printStackTrace();
        } catch (AuthorizationFailedException e) {
            throw new AuthorizationFailedException("Failed to Authorize");
        }
    }
}
