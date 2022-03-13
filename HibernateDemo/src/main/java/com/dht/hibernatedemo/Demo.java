/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.hibernatedemo;

import com.dht.pojo.Cart;
import com.dht.service.OrderService;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Demo {
    public static void main(String[] args) throws ParseException {
        List<Cart> carts = new ArrayList<>();
        carts.add(new Cart(1, "iPhone 7 Plus", 11000000L, 2));
        carts.add(new Cart(2, "Galaxy Note 10", 21000000L, 3));
        
        OrderService s = new OrderService();
        s.addOrder(carts);
//        StatsService s = new StatsService();
//        List<Object[]> results = s.cateStats();
//        
//        results.forEach(o -> {
//            System.out.printf("%d - %s: %d\n", o[0], o[1], o[2]);
//        });
        
//        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
//        List<Object[]> results = s.getRevenueByProduct("", f.parse("2020-02-03"), f.parse("2020-02-04"));
//        results.forEach(o -> {
//            System.out.printf("%d - %s - %d VND: %d VND\n", o[0], o[1], o[2], o[3]);
//        });

//        List<Object[]> results = s.getRevenueByQuarter(2020);
//        results.forEach(o -> {
//            System.out.printf("%d - %d VND\n", o[0], o[1]);
//        });

//        ProductService s = new ProductService();
//        Map<String, String> pre = new HashMap<>();
//        pre.put("kw", "iPhone");
//        pre.put("fromPrice", "30000000");
//        pre.put("cateId", "1");
//        List<Product> products = s.getProducts(pre);
//        List<Product> products = s.getProducts(null, 1);
//        
//        products.forEach(p -> System.out.println(p));
    }
}
