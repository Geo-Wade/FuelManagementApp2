package com.FuelManager.FuelManagement;

import com.FuelManager.FuelManagement.Control.CLIControl;
import com.FuelManager.FuelManagement.Control.StartStopFuelingControl;
import com.FuelManager.FuelManagement.Model.Equipment;
import com.FuelManager.FuelManagement.Model.FuelingPosition;
import com.FuelManager.FuelManagement.Model.Operator;
import com.FuelManager.FuelManagement.Model.Product;
import com.FuelManager.FuelManagement.Repository.EquipmentRepo;
import com.FuelManager.FuelManagement.Repository.FuelingPositionRepo;
import com.FuelManager.FuelManagement.Repository.OperatorRepo;
import com.FuelManager.FuelManagement.Repository.ProductRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class FuelManagementApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(FuelManagementApplication.class, args);

		CLIControl startStopFueling = applicationContext.getBean(StartStopFuelingControl.class);

		EquipmentRepo equipmentRepo = applicationContext.getBean(EquipmentRepo.class);

		OperatorRepo operatorRepo = applicationContext.getBean(OperatorRepo.class);

		FuelingPositionRepo fuelingPositionRepo = applicationContext.getBean(FuelingPositionRepo.class);

		ProductRepo productRepo = applicationContext.getBean(ProductRepo.class);

		Product p1 = new Product();
		p1.setProductName("Diesel");
		productRepo.save(p1);

		Product p2 = new Product();
		p2.setProductName("Unleaded");
		productRepo.save(p2);

		FuelingPosition fp1 = new FuelingPosition();
		fp1.setProduct(p1);
		fp1.setFuelingPositionNumber(1);
		fp1.setFuelingPositionName("Diesel");
		fuelingPositionRepo.save(fp1);

		FuelingPosition fp2 = new FuelingPosition();
		fp2.setProduct(p2);
		fp2.setFuelingPositionNumber(2);
		fp2.setFuelingPositionName("Diesel");
		fuelingPositionRepo.save(fp2);

		FuelingPosition fp3 = new FuelingPosition();
		fp3.setProduct(p1);
		fp3.setFuelingPositionNumber(3);
		fp3.setFuelingPositionName("Diesel");
		fuelingPositionRepo.save(fp3);

		FuelingPosition fp4 = new FuelingPosition();
		fp4.setProduct(p2);
		fp4.setFuelingPositionNumber(4);
		fp4.setFuelingPositionName("Diesel");
		fuelingPositionRepo.save(fp4);

		Equipment e1 = new Equipment();
		e1.setId("1234");
		e1.setEquipmentMake("Ford");
		e1.setEquipmentModel("F150");
		e1.setEquipmentYear(2025);
		e1.setEquipmentOdometer(25000);
		e1.setProducts(List.of(p2));
		equipmentRepo.save(e1);

		Equipment e2 = new Equipment();
		e2.setId("5678");
		e2.setEquipmentMake("Dodge");
		e2.setEquipmentModel("Ram");
		e2.setEquipmentYear(2023);
		e2.setEquipmentOdometer(50000);
		e2.setProducts(List.of(p1));
		equipmentRepo.save(e2);

		Operator o1 = new Operator();
		o1.setOperatorID("4321");
		o1.setOperatorFirstName("John");
		o1.setOperatorLastName("Doe");
		operatorRepo.save(o1);


		while(true) {
			startStopFueling.execute();
		}
	}
}
