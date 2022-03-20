/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.controllers;

import com.dht.service.CategorySerivce;
import com.dht.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Admin
 */
@Controller
public class HomeController {
    @Autowired
    private CategorySerivce categorySerivce;
    @Autowired
    private ProductService productSerivice;
 
    @RequestMapping("/")
    public String index(Model model) {
       
        model.addAttribute("categories", this.categorySerivce.getCategories());
        model.addAttribute("products", this.productSerivice.getProducts(null, 1));
        model.addAttribute("topProducts", this.productSerivice.getTopProducts(5));
        return "index";
    }
}
