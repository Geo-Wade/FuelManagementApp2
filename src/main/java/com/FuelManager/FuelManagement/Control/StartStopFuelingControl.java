package com.FuelManager.FuelManagement.Control;

import com.FuelManager.FuelManagement.Exceptions.AuthorizationFailedException;
import com.FuelManager.FuelManagement.Exceptions.InvalidInputException;
import com.FuelManager.FuelManagement.Services.FuelingAuthorizer;
import com.FuelManager.FuelManagement.Services.FuelingAuthorizerImpl;
import com.FuelManager.FuelManagement.Services.FuelingManager;
import org.springframework.stereotype.Component;

@Component
public class StartStopFuelingControl implements CLIControl {

    IOControl outputControl;
    FuelingManager fuelingManager;

    public StartStopFuelingControl(IOControl outputControl, FuelingManager fuelingManager) {
        this.outputControl = outputControl;
        this.fuelingManager = fuelingManager;

    }

    @Override
    public void execute() {
        int response;
        try {
            response = outputControl.intHandler("1) Start Fueling\t2) Stop Fueling");
            if(response == 1) {
                fuelingManager.startFueling();
            } else if(response == 2) {
                fuelingManager.stopFueling(outputControl.intHandler("Select Fueling Position"));
            }
        } catch (InvalidInputException e) {
            e.printStackTrace();
        } catch (AuthorizationFailedException e) {

        }
    }
}
