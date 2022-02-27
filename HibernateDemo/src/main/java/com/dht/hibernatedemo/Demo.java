/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.hibernatedemo;

import com.dht.pojo.Category;
import com.dht.pojo.Product;
import com.dht.service.ProductService;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Admin
 */
public class Demo {
    public static void main(String[] args) {
        ProductService s = new ProductService();
        
//        Map<String, String> pre = new HashMap<>();
//        pre.put("kw", "iPhone");
//        pre.put("fromPrice", "30000000");
//        pre.put("cateId", "1");
        
//        List<Product> products = s.getProducts(pre);
        List<Product> products = s.getProducts(null, 1);
        
        products.forEach(p -> System.out.println(p));
    }
}
