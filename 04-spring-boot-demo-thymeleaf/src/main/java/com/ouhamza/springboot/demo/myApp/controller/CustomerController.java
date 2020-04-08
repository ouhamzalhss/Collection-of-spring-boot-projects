package com.ouhamza.springboot.demo.myApp.controller;

import com.ouhamza.springboot.demo.myApp.dao.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

/**
 * @author Lhouceine OUHAMZA
 */
@Controller
public class CustomerController {

    @Autowired
   private CustomerRepo customerRepo;

    @GetMapping("/customers")
    public String getCostumers(Model model){
        model.addAttribute("customers", customerRepo.findAll());
        model.addAttribute("theDate", new Date());
        return "customers-list";
    }
}
