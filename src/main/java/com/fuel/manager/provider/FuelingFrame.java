package com.fuel.manager.provider;

import org.springframework.data.repository.cdi.Eager;
import org.springframework.stereotype.Component;

@Component
@Eager
public interface FuelingFrame {
    void updateBar(int fpNumber, double amount);
}
