package com.fuel.manager.dao.repositories;

import com.fuel.manager.dao.model.tables.accounted.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, String> {
}
