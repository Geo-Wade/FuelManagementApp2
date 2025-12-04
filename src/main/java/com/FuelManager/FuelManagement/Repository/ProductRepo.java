package com.FuelManager.FuelManagement.Repository;

import com.FuelManager.FuelManagement.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, String> {
}
