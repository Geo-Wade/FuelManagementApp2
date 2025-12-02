package com.FuelManager.FuelManagement.Services.Authorization;

import org.springframework.stereotype.Service;

@Service
public interface OperatorAuthorizer {
    boolean authorizeOperator(String operatorID);
}
