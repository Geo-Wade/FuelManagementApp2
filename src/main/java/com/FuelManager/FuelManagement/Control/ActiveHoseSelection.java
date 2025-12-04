package com.FuelManager.FuelManagement.Control;

import com.FuelManager.FuelManagement.Services.FuelingManager;
import com.FuelManager.FuelManagement.Services.FuelingPositionManager;;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActiveHoseSelection implements CLIControl{
    IOControl ioControl;
    FuelingPositionManager fuelingPositionManager;
    FuelingManager fuelingManager;

    ActiveHoseSelection(IOControl ioControl,
                        FuelingPositionManager fuelingPositionManager,
                        FuelingManager fuelingManager) {
        this.ioControl = ioControl;
        this.fuelingPositionManager = fuelingPositionManager;
        this.fuelingManager = fuelingManager;

    }
    @Override
    public void execute() {
        List<Integer> hoseList = fuelingPositionManager.getActiveFuelingPositionById();
        if(!hoseList.isEmpty()) {
            int hoseSelection;
            boolean validSelection = false;
            while (!validSelection) {
                hoseSelection = ioControl.intHandler(printHoseSelection(hoseList));
                if (hoseList.contains(hoseSelection)) {
                    fuelingManager.inactivateHose(hoseSelection);
                    validSelection = true;
                } else {
                    ioControl.println("Please select a valid hose");
                }
            }
        }
        else {
            ioControl.println("There are no hoses currently in use");
        }
    }

    String printHoseSelection(List<Integer> availableHoses) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Please select position to deactivate\n");
        for(int fpId : availableHoses) {
            stringBuilder.append("\t")
                    .append("(")
                    .append(fpId)
                    .append(")");
        }
        return stringBuilder.toString();
    }
}
