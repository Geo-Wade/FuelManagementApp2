package com.fuel.manager.services.authorizers.operator;

import com.fuel.manager.exceptions.AuthorizationFailedException;
import com.fuel.manager.dao.model.tables.authrorized.operator.Operator;
import com.fuel.manager.dao.repositories.OperatorRepo;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class OperatorAuthorizerImpl implements OperatorAuthorizer{
    OperatorRepo operatorRepo;
    OperatorAuthorizerImpl(OperatorRepo operatorRepo) {
        this.operatorRepo = operatorRepo;
    }
    @Override
    public Operator authorize(String operatorId) throws AuthorizationFailedException {
        try {
            return operatorRepo.findById(operatorId).orElseThrow();
        } catch (NoSuchElementException noSuchElementException) {
            throw new AuthorizationFailedException("Invalid operator entered");
        }
    }
}
