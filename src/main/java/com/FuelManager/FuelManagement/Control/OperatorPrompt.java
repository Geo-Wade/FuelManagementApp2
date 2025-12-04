package com.FuelManager.FuelManagement.Control;

import com.FuelManager.FuelManagement.Exceptions.AuthorizationFailedException;
import com.FuelManager.FuelManagement.Repository.OperatorRepo;
import com.FuelManager.FuelManagement.Services.TransactionBuilder;
import org.springframework.stereotype.Component;

@Component
public class OperatorPrompt implements CLIControl {
    IOControl ioControl;
    InactiveHoseSelection inactiveHoseSelection;
    TransactionBuilder transactionBuilder;
    OperatorRepo operatorRepo;

    OperatorPrompt(IOControl ioControl,
                   InactiveHoseSelection inactiveHoseSelection,
                   TransactionBuilder transactionBuilder,
                   OperatorRepo operatorRepo) {
        this.ioControl = ioControl;
        this.inactiveHoseSelection = inactiveHoseSelection;
        this.transactionBuilder = transactionBuilder;
        this.operatorRepo = operatorRepo;
    }

    @Override
    public void execute() {
        try {
            transactionBuilder.addOperator(ioControl.stringHandler("Enter Operator ID"));
            inactiveHoseSelection.execute();
        } catch (AuthorizationFailedException authorizationFailedException) {
            ioControl.println("Failed to Authorize");
        }
    }
}
