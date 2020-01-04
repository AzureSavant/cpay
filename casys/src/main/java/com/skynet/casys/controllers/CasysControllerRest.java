package com.skynet.casys.controllers;

import com.skynet.casys.models.CasysProduct;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class CasysControllerRest {

    @RequestMapping("/test/{product}")
    @ResponseBody
    public CasysProduct test(@PathVariable("product") String product,Model model){

        return  new CasysProduct(product); //CasysProduct casysProduct=new CasysProduct(product);

    }

}
