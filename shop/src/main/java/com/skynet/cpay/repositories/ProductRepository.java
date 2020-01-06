package com.skynet.cpay.repositories;

import com.skynet.cpay.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product getProductById(int productId);
    Product getProductByNameContains(String product);


    @Override
    List<Product> findAll();
}
