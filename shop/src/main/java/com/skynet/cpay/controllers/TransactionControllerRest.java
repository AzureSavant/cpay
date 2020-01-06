package com.skynet.cpay.controllers;

import com.skynet.cpay.models.Product;
import com.skynet.cpay.models.Transaction;
import com.skynet.cpay.service.ProductService;
import com.skynet.cpay.service.impl.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionControllerRest {
    private ProductService productService;
    private TransactionServiceImpl transactionService;

    @Autowired
    public TransactionControllerRest(ProductService productService, TransactionServiceImpl transactionService) {
        this.productService = productService;
        this.transactionService = transactionService;
    }

    @RequestMapping("/shop/transaction/{transId}")
    public Transaction restTransaction(@PathVariable("transId") Integer transId){
        return this.transactionService.getById(transId);
    }

    @PostMapping("/shop/casys/transactionRequest/")
    public void saveTransaction(@RequestBody String info){

        Transaction t= new Transaction(info);
        transactionService.saveTransaction(t);
    }

}
