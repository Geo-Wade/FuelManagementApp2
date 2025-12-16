package com.fuel.manager.services.fueling.position.management;


import java.util.List;

public interface FuelingPositionManager {
    List<Integer> getActiveFuelingPositionById();

    List<Integer> getInactiveFuelingPositionById(int trId);
}
