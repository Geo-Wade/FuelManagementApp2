package com.fuel.manager.provider;

import org.springframework.stereotype.Component;

@Component
public interface ExternalFuelingTask extends Runnable {
    double stopAndGetTotal();
}
