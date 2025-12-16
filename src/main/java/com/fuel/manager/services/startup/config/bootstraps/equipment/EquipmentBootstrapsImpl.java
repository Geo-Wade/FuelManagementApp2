package com.fuel.manager.services.startup.config.bootstraps.equipment;

import com.fuel.manager.dao.model.tables.authrorized.equipment.Equipment;
import com.fuel.manager.dao.repositories.EquipmentRepo;
import com.fuel.manager.dao.repositories.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EquipmentBootstrapsImpl implements EquipmentBootstraps{
    EquipmentRepo equipmentRepo;
    ProductRepo productRepo;
    EquipmentBootstrapsImpl(EquipmentRepo equipmentRepo,
                            ProductRepo productRepo) {
        this.equipmentRepo = equipmentRepo;
        this.productRepo = productRepo;

    }

    public void bootStrapEquipment() {
        Equipment e1 = new Equipment();
        e1.setId("1111");
        e1.setEquipmentYear(2025);
        e1.setEquipmentMake("Ford");
        e1.setEquipmentModel("F150");
        e1.setEquipmentOdometer(25000);
        e1.setProducts(List.of(productRepo.findById("Unleaded").orElseThrow()));
        equipmentRepo.save(e1);

        Equipment e2 = new Equipment();
        e2.setId("2222");
        e2.setEquipmentYear(2015);
        e2.setEquipmentMake("Peterbuilt");
        e2.setEquipmentModel("Big Truck Thing");
        e2.setEquipmentOdometer(50000);
        e2.setProducts(List.of(productRepo.findById("Diesel").orElseThrow()));
        equipmentRepo.save(e2);
    }
}
