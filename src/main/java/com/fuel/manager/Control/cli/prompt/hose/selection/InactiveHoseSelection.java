package com.fuel.manager.Control.cli.prompt.hose.selection;

import com.fuel.manager.Control.cli.utilities.CLIControl;
import com.fuel.manager.Control.cli.utilities.IOControl;
import com.fuel.manager.services.fueling.management.FuelingManager;
import com.fuel.manager.services.fueling.position.management.FuelingPositionManager;
import com.fuel.manager.services.transaction.builder.TransactionBuilder;
import com.fuel.manager.services.transaction.builder.startup.StartupTransactionBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InactiveHoseSelection implements CLIControl {
    FuelingManager fuelingManager;
    IOControl ioControl;
    FuelingPositionManager fuelingPositionManager;
    StartupTransactionBuilder startupTransactionBuilder;

    InactiveHoseSelection(FuelingManager fuelingManager,
                          IOControl ioControl,
                          FuelingPositionManager fuelingPositionManager,
                          StartupTransactionBuilder startupTransactionBuilder) {
        this.fuelingManager = fuelingManager;
        this.ioControl = ioControl;
        this.fuelingPositionManager = fuelingPositionManager;
        this.startupTransactionBuilder = startupTransactionBuilder;
    }

    @Override
    public void execute(int trId) {
        boolean validSelection = false;
        while (!validSelection) {
            List<Integer> hoseList = fuelingPositionManager.getInactiveFuelingPositionById(trId);
            if (!hoseList.isEmpty()) {
                int hoseSelection = ioControl.intHandler(buildHoseListString(hoseList));
                startupTransactionBuilder.setFuelingPosition(trId, hoseSelection);
                if (hoseList.contains(hoseSelection)) {
                    fuelingManager.activateHose(hoseSelection);
                    startupTransactionBuilder.buildTransactionFromStartupTransaction(trId);
                    validSelection = true;
                } else {
                    ioControl.println("Please Enter a valid Hose");
                }
            } else {
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
