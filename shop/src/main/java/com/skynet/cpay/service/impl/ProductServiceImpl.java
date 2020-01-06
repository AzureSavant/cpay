package com.skynet.cpay.service.impl;

import com.skynet.cpay.models.Product;
import com.skynet.cpay.repositories.ProductRepository;
import com.skynet.cpay.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class ProductServiceImpl implements ProductService {

    private ProductRepository ProductRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository ProductRepository){
        this.ProductRepository=ProductRepository;
    }

    @Override
    public Product getProductByNameContains(String product) {
        return  this.ProductRepository.getProductByNameContains(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return ProductRepository.findAll();
    }

    @Override
    public Product getByID(int deviceID) {
        return ProductRepository.getProductById(deviceID);
    }
}
