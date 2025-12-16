package com.fuel.manager.services.startup.config.bootstraps.product;

import com.fuel.manager.dao.model.tables.accounted.Product;
import com.fuel.manager.dao.repositories.FuelingPositionRepo;
import com.fuel.manager.dao.repositories.ProductRepo;
import org.springframework.stereotype.Service;

@Service
public class ProductBootStrapsImpl implements ProductBootStraps{
    ProductRepo productRepo;
    ProductBootStrapsImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
    public void bootStrapProducts() {
        Product p1 = new Product();
        p1.setProductName("Diesel");
        productRepo.save(p1);

        Product p2 = new Product();
        p2.setProductName("Unleaded");
        productRepo.save(p2);
    }
}
