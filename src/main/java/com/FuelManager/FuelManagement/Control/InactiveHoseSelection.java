package com.FuelManager.FuelManagement.Control;

import com.FuelManager.FuelManagement.Services.FuelingManager;
import com.FuelManager.FuelManagement.Services.FuelingPositionManager;
import org.springframework.stereotype.Component;

@Component
public class InactiveHoseSelection implements CLIControl{
    FuelingManager fuelingManager;
    IOControl ioControl;
    FuelingPositionManager fuelingPositionManager;
    InactiveHoseSelection(FuelingManager fuelingManager, IOControl ioControl, FuelingPositionManager fuelingPositionManager) {
        this.fuelingManager = fuelingManager;
        this.ioControl = ioControl;
        this.fuelingPositionManager = fuelingPositionManager;
    }
    @Override
    public void execute() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Please select position to activate\n");
        for(int fpId : fuelingPositionManager.getActiveFuelingPositionById()) {
            stringBuilder.append("\t")
                    .append("(")
                    .append(fpId)
                    .append(")");
        }
        int hoseSelection = ioControl.intHandler(stringBuilder.toString());

        fuelingManager.stopFueling(hoseSelection);
    }
}
