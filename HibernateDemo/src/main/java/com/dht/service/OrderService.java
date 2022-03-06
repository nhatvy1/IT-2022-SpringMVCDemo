/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.service;

import com.dht.hibernatedemo.HibernateUtils;
import com.dht.pojo.Cart;
import com.dht.pojo.OrderDetail;
import com.dht.pojo.Product;
import com.dht.pojo.SaleOrder;
import com.dht.pojo.User;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Admin
 */
public class OrderService {
    private static final SessionFactory factory = HibernateUtils.getSessionFactory();
    
    public boolean addOrder(List<Cart> carts) {
        try (Session session = factory.openSession()) {
            try {
            session.getTransaction().begin();
            SaleOrder order = new SaleOrder();
            order.setUserId(session.get(User.class, 1));
            session.save(order);
            
            carts.forEach(c -> {
                OrderDetail d = new OrderDetail();
                d.setUnitPrice(c.getPrice());
                d.setNum(c.getQuantity());
                d.setOrderId(order);
                d.setProductId(session.get(Product.class, c.getId()));
                session.save(d);
            });
            session.getTransaction().commit();
            return true;
            } catch (HibernateException ex) {
                session.getTransaction().rollback();
                ex.printStackTrace();
            }
        }
        return false;
    }
}
