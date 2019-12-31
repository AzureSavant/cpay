package com.skynet.casys.controllers;

import com.skynet.casys.models.Casys;
import com.skynet.casys.models.Transaction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CasysController {

    @RequestMapping("/casys")
    public Casys transactionMethod(@RequestParam(value="id", defaultValue="1000") Integer id,
                                   @RequestParam(value = "product",defaultValue ="product") String product){
        return new Casys(id,product);
    }
}
