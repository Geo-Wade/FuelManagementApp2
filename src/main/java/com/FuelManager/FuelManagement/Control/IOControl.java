package com.FuelManager.FuelManagement.Control;

import org.springframework.stereotype.Component;

@Component
public interface IOControl {
    public int intHandler(String message);
    public String stringHandler(String message);
}
