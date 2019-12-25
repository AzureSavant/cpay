package com.skynet.cpay.controllers;

import com.skynet.cpay.models.Product;
import com.skynet.cpay.service.ProductService;
import com.skynet.cpay.service.impl.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller

public class ShopController {
    private ProductService productService;
    public ShopController(ProductService productService){
        this.productService=productService;
    }

    @RequestMapping(value = "/shop")
    public String products(Model model) {
        model.addAttribute("ProductList",productService.getAllProducts());
        return "shop.html";
    }




}
