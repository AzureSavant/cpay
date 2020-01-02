package com.skynet.cpay.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CasysController {

   /* @RequestMapping(value = "/casys", method = RequestMethod.POST,params = "checkout")
    public String casys(
            Model model,
            @RequestParam("product") String product,
            @RequestParam("id") Integer id){

        model.addAttribute("product", product);
        model.addAttribute("id", id);
        return "casys.html";
    }
    @RequestMapping(value = "/casys", method = RequestMethod.GET)
    public String onRedirect(
            Model model,
            @RequestParam("product") String product,
            @RequestParam("id") Integer id){

        model.addAttribute("product", product);
        model.addAttribute("id", id);
        return "casys.html";
    }
*/
    @RequestMapping(value = "/casys", method = RequestMethod.POST,params = "back")
    public  String back(){
        return "redirect:/shop";
    }


    @RequestMapping(value = "/casys",method = RequestMethod.POST,params = "checkout")
    public String test(@RequestParam(value = "product") String product
                       ){

        return "redirect:http://localhost:8081/casys/"+ product;
    }
}
