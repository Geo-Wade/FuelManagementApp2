package com.FuelManager.FuelManagement.Control;

import com.FuelManager.FuelManagement.Services.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InactiveHoseSelection implements CLIControl{
    FuelingManager fuelingManager;
    IOControl ioControl;
    FuelingPositionManager fuelingPositionManager;
    TransactionManager transactionManager;
    TransactionBuilder transactionBuilder;
    InactiveHoseSelection(FuelingManager fuelingManager,
                          IOControl ioControl,
                          FuelingPositionManager fuelingPositionManager,
                          TransactionManager transactionManager,
                          TransactionBuilder transactionBuilder) {
        this.fuelingManager = fuelingManager;
        this.ioControl = ioControl;
        this.fuelingPositionManager = fuelingPositionManager;
        this.transactionManager = transactionManager;
        this.transactionBuilder = transactionBuilder;
    }
    @Override
    public void execute() {
        boolean validSelection = false;
        while(!validSelection) {
            List<Integer> hoseList = fuelingPositionManager.getInactiveFuelingPositionById();
            if(!hoseList.isEmpty()) {
                int hoseSelection = ioControl.intHandler(buildHoseListString(hoseList));
                if (hoseList.contains(hoseSelection)) {
                    fuelingManager.activateHose(hoseSelection);
                    transactionManager.addActiveTransaction(transactionBuilder.addFuelingPosition(hoseSelection));
                    transactionBuilder.clearTransaction();
                    validSelection = true;
                } else {
                    ioControl.println("Please Enter a valid Hose");
                }
            }
            else {
                ioControl.println("No hoses authorized for this equipment are available");
                validSelection = true;
            }
        }
    }
    String buildHoseListString(List<Integer> hoseList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Please select position to activate\n");
        for (int fpId : hoseList) {
            stringBuilder.append("\t")
                    .append("(")
                    .append(fpId)
                    .append(")");
        }
        return stringBuilder.toString();
    }
}
