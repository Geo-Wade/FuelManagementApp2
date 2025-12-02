package com.FuelManager.FuelManagement.Services;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface FuelingPositionManager {
    List<Integer> getActiveFuelingPositionById();
    List<Integer> getInactiveFuelingPositionById();
}
