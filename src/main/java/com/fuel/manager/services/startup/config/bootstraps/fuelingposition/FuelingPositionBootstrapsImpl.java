package com.fuel.manager.services.startup.config.bootstraps.fuelingposition;

import com.fuel.manager.dao.model.tables.controlled.fueling.FuelingPosition;
import com.fuel.manager.dao.model.tables.accounted.Product;
import com.fuel.manager.dao.repositories.FuelingPositionRepo;
import com.fuel.manager.dao.repositories.ProductRepo;
import org.springframework.stereotype.Service;

@Service
public class FuelingPositionBootstrapsImpl implements FuelingPositionBootStraps {
    FuelingPositionRepo fuelingPositionRepo;
    ProductRepo productRepo;

    FuelingPositionBootstrapsImpl(FuelingPositionRepo fuelingPositionRepo, ProductRepo productRepo) {
        this.fuelingPositionRepo = fuelingPositionRepo;
        this.productRepo = productRepo;
    }

    @Override
    public void bootStrapFuelingPosition() {
        FuelingPosition fp1 = new FuelingPosition();
        fp1.setFuelingPositionNumber(1);
        fp1.setFuelingPositionName("Diesel");
        fp1.setProduct(productRepo.findById("Diesel").orElse(new Product()));
        fuelingPositionRepo.save(fp1);

        FuelingPosition fp2 = new FuelingPosition();
        fp2.setFuelingPositionNumber(2);
        fp2.setFuelingPositionName("Unleaded");
        fp2.setProduct(productRepo.findById("Unleaded").orElse(new Product()));
        fuelingPositionRepo.save(fp2);
    }
}
