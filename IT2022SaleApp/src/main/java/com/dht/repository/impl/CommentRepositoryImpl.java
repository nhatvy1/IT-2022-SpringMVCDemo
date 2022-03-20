/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.repository.impl;

import com.dht.pojo.Comment;
import com.dht.pojo.User;
import com.dht.repository.CommentRepository;
import com.dht.repository.ProductRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class CommentRepositoryImpl implements CommentRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private ProductRepository productRepository;
    
    @Override
    public Comment addComment(String content, int productId) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Comment c = new Comment();
        c.setContent(content);
        c.setProduct(this.productRepository.getProductById(productId));
        User u = s.get(User.class, 6);
        c.setUser(u);
//        try {
            s.save(c);
            return c;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return null;
//        }
    }
    
}
