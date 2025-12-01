package com.FuelManager.FuelManagement;

import com.FuelManager.FuelManagement.Control.CLIControl;
import com.FuelManager.FuelManagement.Control.StartStopFuelingControl;
import com.FuelManager.FuelManagement.Model.Equipment;
import com.FuelManager.FuelManagement.Model.FuelingPosition;
import com.FuelManager.FuelManagement.Model.Transaction;
import com.FuelManager.FuelManagement.Repository.EquipmentRepo;
import com.FuelManager.FuelManagement.Repository.FuelingPositionRepo;
import com.FuelManager.FuelManagement.Services.TransactionManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;

@SpringBootApplication
public class FuelManagementApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(FuelManagementApplication.class, args);

		CLIControl startStopFueling = applicationContext.getBean(StartStopFuelingControl.class);

		EquipmentRepo equipmentRepo = applicationContext.getBean(EquipmentRepo.class);

		FuelingPositionRepo fuelingPositionRepo = applicationContext.getBean(FuelingPositionRepo.class);

		TransactionManager transactionManager = applicationContext.getBean(TransactionManager.class);

		FuelingPosition fp1 = new FuelingPosition();
		fp1.setFuelingPositionNumber(1);
		fp1.setFuelingPositionName("Diesel 1");
		fp1.setProduct("Diesel");
		fuelingPositionRepo.save(fp1);

		FuelingPosition fp2 = new FuelingPosition();
		fp2.setFuelingPositionNumber(2);
		fp2.setFuelingPositionName("Unleaded 1");
		fp2.setProduct("Unleaded");
		fuelingPositionRepo.save(fp2);

		FuelingPosition fp3 = new FuelingPosition();
		fp3.setFuelingPositionNumber(3);
		fp3.setFuelingPositionName("Diesel 1");
		fp3.setProduct("Diesel");
		fuelingPositionRepo.save(fp3);

		Equipment e1 = new Equipment();
		e1.setId("1234");
		e1.setEquipmentMake("Ford");
		e1.setEquipmentModel("F150");
		e1.setEquipmentYear(2025);
		e1.setEquipmentOdometer(25000);

		equipmentRepo.save(e1);

		while(true) {
			startStopFueling.execute();
		}
	}
}
