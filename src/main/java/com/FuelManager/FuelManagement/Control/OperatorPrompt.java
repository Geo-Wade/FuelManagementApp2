package com.FuelManager.FuelManagement.Control;

import com.FuelManager.FuelManagement.Services.Authorization.OperatorAuthorizer;
import com.FuelManager.FuelManagement.Services.TransactionBuilder;
import org.springframework.stereotype.Component;

@Component
public class OperatorPrompt implements CLIControl {
    IOControl ioControl;
    OperatorAuthorizer operatorAuthorizer;
    ActiveHoseSelection activeHoseSelection;
    TransactionBuilder transactionBuilder;

    OperatorPrompt(IOControl ioControl, OperatorAuthorizer operatorAuthorizer, ActiveHoseSelection activeHoseSelection, TransactionBuilder transactionBuilder) {
        this.ioControl = ioControl;
        this.operatorAuthorizer = operatorAuthorizer;
        this.activeHoseSelection = activeHoseSelection;
        this.transactionBuilder = transactionBuilder;
    }

    @Override
    public void execute() {
        String operatorID = ioControl.stringHandler("Enter Operator ID");
        if(operatorAuthorizer.authorizeOperator(operatorID.toUpperCase())) {
            System.out.println("Authorized for operator" + operatorID);
            transactionBuilder.addOperator(operatorID);
            activeHoseSelection.execute();
        }
        else {
            ioControl.println("Invalid Operator ID");
        }
    }
}
