package com.fuel.manager.Control.cli.utilities;

import org.springframework.stereotype.Component;

@Component
public interface CLIControl {
    void execute(int trId);
}
