package com.fuel.manager.services.startup;

import com.fuel.manager.Control.cli.start.StartStopFuelingControl;
import com.fuel.manager.services.startup.config.bootstraps.BootstrapService;
import org.springframework.stereotype.Service;

@Service
public class FuelManagementImpl implements FuelManagement {

    StartStopFuelingControl startStopFuelingControl;
    BootstrapService bootstrapService;

    public FuelManagementImpl(BootstrapService bootstrapService, StartStopFuelingControl startStopFuelingControl) {
        this.bootstrapService = bootstrapService;
        this.startStopFuelingControl = startStopFuelingControl;
    }

    public int run() {
        bootstrapService.runBootStrappedData();
        startStopFuelingControl.start();
        return 0;
    }
}
