package com.skynet.casys.controllers;

import org.hibernate.validator.constraints.URL;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;


@Controller
public class CasysController {

    @RequestMapping("/casys/{product}")
    public String casys(@PathVariable("product") String product,
                        @RequestParam("baseUrl") String baseURL,
                        @RequestParam("price") Double price,
                        Model model) throws UnsupportedEncodingException {
        model.addAttribute("product",URLDecoder.decode(product,"UTF-8"));
        model.addAttribute("price",price);
        model.addAttribute("Sproduct",product);
        String baseUrl= URLDecoder.decode(baseURL,"UTF-8");
        model.addAttribute("baseUrl",baseUrl);

        return "casys.html";
    }

    @RequestMapping("/redirectshop")
    public String redirectShop(@RequestParam("baseUrl") String baseUrl){

        return "redirect:"+baseUrl;
    }

    @RequestMapping("/casys/retry")
    public String redirectFail(@RequestParam("baseUrl") String baseUrl) {

        return "redirect:http://localhost:8081/casys/"+baseUrl;
    }



}
