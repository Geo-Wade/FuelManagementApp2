package com.FuelManager.FuelManagement.Control;

import com.FuelManager.FuelManagement.Exceptions.InvalidInputException;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class IOControlmpl implements IOControl {
    Scanner scanner = new Scanner(System.in);
    boolean invalidResponse = true;
    public int intHandler(String message) {
        while(invalidResponse) {
            System.out.println(message);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid Response");
            }
        }
        throw new InvalidInputException("The Response has generated an error");
    }
    public String stringHandler(String message) {
        System.out.println(message);
        String response = scanner.nextLine();
        return response.trim();
    }

    @Override
    public void println(String message) {
        System.out.println(message);
    }
}
