package com.fuel.manager.services.startup.config.bootstraps;

import com.fuel.manager.services.startup.config.bootstraps.equipment.EquipmentBootstraps;
import com.fuel.manager.services.startup.config.bootstraps.fuelingposition.FuelingPositionBootStraps;
import com.fuel.manager.services.startup.config.bootstraps.operator.OperatorBootStrap;
import com.fuel.manager.services.startup.config.bootstraps.product.ProductBootStraps;
import org.springframework.stereotype.Service;

@Service
public class BootstrapServiceImpl implements BootstrapService {
    ProductBootStraps productBootStraps;
    OperatorBootStrap operatorBootStrap;
    FuelingPositionBootStraps fuelingPositionBootStraps;
    EquipmentBootstraps equipmentBootstraps;

    BootstrapServiceImpl(ProductBootStraps productBootStraps,
                         OperatorBootStrap operatorBootStrap,
                         FuelingPositionBootStraps fuelingPositionBootStraps,
                         EquipmentBootstraps equipmentBootstraps) {
        this.productBootStraps = productBootStraps;
        this.operatorBootStrap = operatorBootStrap;
        this.fuelingPositionBootStraps = fuelingPositionBootStraps;
        this.equipmentBootstraps = equipmentBootstraps;
    }

    @Override
    public void runBootStrappedData() {
        productBootStraps.bootStrapProducts();
        operatorBootStrap.bootStrapFuelingOperator();
        fuelingPositionBootStraps.bootStrapFuelingPosition();
        equipmentBootstraps.bootStrapEquipment();
    }
}
