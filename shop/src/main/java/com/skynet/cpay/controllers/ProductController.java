package com.skynet.cpay.controllers;


import com.skynet.cpay.models.Product;
import com.skynet.cpay.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    private final ProductService productService;

    @ResponseBody
    public Product restProduct(@RequestParam(value="id") int id){
        return this.productService.getByID(id);
    }
}
