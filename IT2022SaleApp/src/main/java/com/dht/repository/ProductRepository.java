/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.repository;

import com.dht.pojo.Product;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface ProductRepository {
    List<Product> getProducts(Map<String, String> params, int page);
    List<Object[]> getTopProducts(int num);
    Product getProductById(int productId);
}
