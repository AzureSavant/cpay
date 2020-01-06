package com.skynet.cpay.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;

@Controller
public class CasysController {

    @RequestMapping(value = "/shop/", method = RequestMethod.POST,params = "back")
    public  String back(){
        return "redirect:/shop";
    }


    @RequestMapping(value = "/shop/",method = RequestMethod.POST,params = "checkout")
    public String test(@RequestParam(value = "product") String product,
                       @RequestParam(value = "sendPrice") Integer price,
                       HttpServletRequest request
                       ) throws UnsupportedEncodingException {

         final String baseUrl=request.getRequestURL().toString();
        return "redirect:http://localhost:8081/casys/"+
                    URLEncoder.encode(product, "UTF-8")+"?baseUrl="+URLEncoder.encode(baseUrl,"UTF-8")+
                    "&price="+price;
    }
}
