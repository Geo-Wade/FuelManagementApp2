package com.fuel.manager;

import com.fuel.manager.services.startup.FuelManagement;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class FuelManagementApplication {

	public static void main(String[] args) {
		System.exit(SpringApplication.run(FuelManagementApplication.class, args).getBean(FuelManagement.class).run());
	}
}
