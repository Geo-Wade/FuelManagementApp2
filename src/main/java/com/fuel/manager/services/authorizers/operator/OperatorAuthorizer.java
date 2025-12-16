package com.fuel.manager.services.authorizers.operator;

import com.fuel.manager.dao.model.tables.authrorized.operator.Operator;

public interface OperatorAuthorizer {
    Operator authorize(String operatorId);
}
