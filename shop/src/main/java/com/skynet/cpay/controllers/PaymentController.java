package com.skynet.cpay.controllers;

import com.skynet.cpay.models.Product;
import com.skynet.cpay.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller

public class PaymentController {
    private ProductService productService;
    public PaymentController(ProductService productService){ this.productService=productService;}

    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    public String payment(
            Model model,
            @RequestParam("id") Integer id
    ) {
        Product product= productService.getByID(id);
        model.addAttribute("name", product.getName());
        model.addAttribute("price", product.getPrice());
        model.addAttribute("manufacturer", product.getManufacturer());
        model.addAttribute("description", product.getDescription());
        model.addAttribute("id", id);
        model.addAttribute("product",product.toString());

        return "payment.html";
    }

}
