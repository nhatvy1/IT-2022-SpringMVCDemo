/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.hibernatedemo;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import com.dht.pojo.Category;
import com.dht.pojo.OrderDetail;
import com.dht.pojo.Product;
import com.dht.pojo.SaleOrder;
import com.dht.pojo.User;


/**
 *
 * @author Admin
 */
public class HibernateUtils {
    private static final SessionFactory factory;
    
    static {
        Configuration conf = new Configuration();
        Properties props = new Properties();
        props.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        props.put(Environment.URL, "jdbc:mysql://localhost:3306/saledb");
        props.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        props.put(Environment.USER, "root");
        props.put(Environment.PASS, "12345678");
        props.put(Environment.SHOW_SQL, "true");
        
        conf.setProperties(props);   
        
        conf.addAnnotatedClass(Category.class);
        conf.addAnnotatedClass(Product.class);
        conf.addAnnotatedClass(OrderDetail.class);
        conf.addAnnotatedClass(SaleOrder.class);
        conf.addAnnotatedClass(User.class);
        
        ServiceRegistry registy = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        
        factory = conf.buildSessionFactory(registy);
    }
    
    public static SessionFactory getSessionFactory() {
        return factory;
    }
}
