package com.fuel.manager.Control.cli.prompt.id;

import com.fuel.manager.Control.cli.utilities.CLIControl;
import com.fuel.manager.Control.cli.utilities.IOControl;
import com.fuel.manager.Control.cli.prompt.hose.selection.InactiveHoseSelection;
import com.fuel.manager.exceptions.AuthorizationFailedException;
import com.fuel.manager.services.authorizers.operator.OperatorAuthorizer;
import com.fuel.manager.services.transaction.builder.startup.StartupTransactionBuilder;
import org.springframework.stereotype.Component;

@Component
public class OperatorPrompt implements CLIControl {
    IOControl ioControl;
    InactiveHoseSelection inactiveHoseSelection;
    StartupTransactionBuilder startupTransactionBuilder;
    OperatorAuthorizer operatorAuthorizer;

    OperatorPrompt(IOControl ioControl,
                   InactiveHoseSelection inactiveHoseSelection,
                   StartupTransactionBuilder startupTransactionBuilder,
                   OperatorAuthorizer operatorAuthorizer) {
        this.ioControl = ioControl;
        this.inactiveHoseSelection = inactiveHoseSelection;
        this.operatorAuthorizer = operatorAuthorizer;
        this.startupTransactionBuilder = startupTransactionBuilder;
    }

    @Override
    public void execute(int trId) {
        try {
            startupTransactionBuilder.addOperator(trId, ioControl.stringHandler("Enter operator ID"));
            inactiveHoseSelection.execute(trId);
        } catch (AuthorizationFailedException authorizationFailedException) {
            ioControl.println("Failed to Authorize");
        }
    }
}
