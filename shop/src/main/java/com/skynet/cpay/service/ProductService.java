package com.skynet.cpay.service;

import com.skynet.cpay.models.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductService {

    List<Product> getAllProducts();
    Product getByID(int deviceID);
}
