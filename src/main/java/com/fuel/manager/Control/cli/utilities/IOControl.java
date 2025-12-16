package com.fuel.manager.Control.cli.utilities;

import org.springframework.stereotype.Component;

@Component
public interface IOControl {
    int intHandler(String message);

    String stringHandler(String message);

    void println(String message);
}
