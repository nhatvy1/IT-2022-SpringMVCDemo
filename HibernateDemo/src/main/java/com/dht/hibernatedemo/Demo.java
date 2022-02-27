/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.hibernatedemo;

import com.dht.pojo.Category;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Admin
 */
public class Demo {
    public static void main(String[] args) {
        SessionFactory f = HibernateUtils.getSessionFactory();
        try (Session s = f.openSession()) {
            Query q = s.createQuery("From Category");
            
            List<Category> cates = q.getResultList();
            cates.forEach(c -> System.out.printf("%d - %s\n", c.getId(), c.getName()));
        }
    }
}
