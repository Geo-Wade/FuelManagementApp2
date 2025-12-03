package com.FuelManager.FuelManagement.Control;

import com.FuelManager.FuelManagement.Services.FuelingManager;
import com.FuelManager.FuelManagement.Services.FuelingPositionManager;
import com.FuelManager.FuelManagement.Services.TransactionBuilder;
import com.FuelManager.FuelManagement.Services.TransactionManager;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActiveHoseSelection implements CLIControl{
    IOControl ioControl;
    FuelingPositionManager fuelingPositionManager;
    FuelingManager fuelingManager;
    TransactionBuilder transactionBuilder;
    TransactionManager transactionManager;
    ActiveHoseSelection(IOControl ioControl,
                        FuelingPositionManager fuelingPositionManager,
                        FuelingManager fuelingManager,
                        TransactionBuilder transactionBuilder,
                        TransactionManager transactionManager) {
        this.ioControl = ioControl;
        this.fuelingPositionManager = fuelingPositionManager;
        this.fuelingManager = fuelingManager;
        this.transactionBuilder = transactionBuilder;
        this.transactionManager = transactionManager;
    }
    @Override
    public void execute() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Please select position to activate\n");
        List<Integer> availableHoses = fuelingPositionManager.getActiveFuelingPositionById();
        for(int fpId : fuelingPositionManager.getInactiveFuelingPositionById()) {
            stringBuilder.append("\t")
                    .append("(")
                    .append(fpId)
                    .append(")");
        }
        int hoseSelection = ioControl.intHandler(stringBuilder.toString());
            transactionManager.addActiveTransaction(transactionBuilder.addFuelingPosition(hoseSelection));
            transactionBuilder.clearTransaction();
            fuelingManager.startFueling(hoseSelection);
    }
}
