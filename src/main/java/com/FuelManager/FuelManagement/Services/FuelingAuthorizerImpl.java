package com.FuelManager.FuelManagement.Services;

import com.FuelManager.FuelManagement.Control.IOControl;
import com.FuelManager.FuelManagement.Exceptions.AuthorizationFailedException;
import com.FuelManager.FuelManagement.Model.Equipment;
import com.FuelManager.FuelManagement.Model.FuelingPosition;
import com.FuelManager.FuelManagement.Model.Operator;
import com.FuelManager.FuelManagement.Repository.FuelingPositionRepo;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
@Service
public class FuelingAuthorizerImpl implements FuelingAuthorizer{

    IOControl ioControl;
    FuelingPositionRepo fuelingPositionRepo;

    FuelingAuthorizerImpl(FuelingPositionRepo fuelingPositionRepo, IOControl ioControl) {
        this.ioControl = ioControl;
        this.fuelingPositionRepo = fuelingPositionRepo;
    }

    @Override
    public FuelingPosition authorizeFuelingPosition() throws AuthorizationFailedException {
       Optional<FuelingPosition> fuelingPosition = fuelingPositionRepo.findById(ioControl.intHandler("Please Select Fueling Position"));
        try {
            return fuelingPosition.orElseThrow();
        } catch (NoSuchElementException e) {
            throw new AuthorizationFailedException("Unauthorized Equipment ID Entered");
        }
    }

    @Override
    public Equipment authorizeEquipmentID() {
        return null;
    }

    @Override
    public Operator authorizeOperatorID() {
        return null;
    }
}
