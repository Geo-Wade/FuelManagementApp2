package com.FuelManager.FuelManagement.Services.Authorization;

import com.FuelManager.FuelManagement.Model.Operator;
import com.FuelManager.FuelManagement.Repository.OperatorRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class OperatorAuthorizerImpl implements OperatorAuthorizer {
    OperatorRepo operatorRepo;
    OperatorAuthorizerImpl(OperatorRepo operatorRepo) {
        this.operatorRepo = operatorRepo;
    }
    @Override
    public boolean authorizeOperator(String operatorID) {
        Optional<Operator> operator = operatorRepo.findById(operatorID.toUpperCase());
        return operator.isPresent();
    }
}
