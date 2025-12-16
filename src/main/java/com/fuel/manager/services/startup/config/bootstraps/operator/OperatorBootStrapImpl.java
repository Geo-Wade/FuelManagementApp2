package com.fuel.manager.services.startup.config.bootstraps.operator;

import com.fuel.manager.dao.model.tables.authrorized.operator.Operator;
import com.fuel.manager.dao.repositories.OperatorRepo;
import org.springframework.stereotype.Service;

@Service
public class OperatorBootStrapImpl implements OperatorBootStrap{

    OperatorRepo operatorRepo;
    OperatorBootStrapImpl(OperatorRepo operatorRepo) {
        this.operatorRepo = operatorRepo;
    }
    public void bootStrapFuelingOperator() {
        Operator o1 = new Operator();
        o1.setOperatorID("9999");
        o1.setOperatorFirstName("Jim");
        o1.setOperatorLastName("Jones");
        operatorRepo.save(o1);

        Operator o2 = new Operator();
        o2.setOperatorID("9999");
        o2.setOperatorFirstName("Jim");
        o2.setOperatorLastName("Jones");
        operatorRepo.save(o2);
    }
}
