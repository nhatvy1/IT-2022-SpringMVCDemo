/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.repository.impl;

import com.dht.pojo.OrderDetail;
import com.dht.pojo.Product;
import com.dht.repository.ProductRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Product> getProducts(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Product> q = b.createQuery(Product.class);
        Root root = q.from(Product.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            if (params.containsKey("kw") == true) {
                Predicate p1 = b.like(root.get("name").as(String.class),
                        String.format("%%%s%%", params.get("kw")));
                predicates.add(p1);
            }

            if (params.containsKey("fromPrice") == true) {
                BigDecimal fromPrice = new BigDecimal(Double.parseDouble(params.get("fromPrice")));
                Predicate p2 = b.greaterThanOrEqualTo(root.get("price").as(String.class), fromPrice);
                predicates.add(p2);
            }

            if (params.containsKey("toPrice") == true) {
                BigDecimal toPrice = new BigDecimal(Double.parseDouble(params.get("toPrice")));
                Predicate p3 = b.lessThanOrEqualTo(root.get("price").as(String.class), toPrice);
                predicates.add(p3);
            }

            if (params.containsKey("cateId") == true) {
                int cateId = Integer.parseInt(params.get("cateId"));
                Predicate p4 = b.equal(root.get("category"), cateId);
                predicates.add(p4);
            }

            q = q.where(predicates.toArray(new Predicate[]{}));
        }

        q = q.orderBy(b.desc(root.get("id")));

        Query query = session.createQuery(q);

        // Phân trang
        int max = 6;
        int index = (page - 1) * max;
        query.setFirstResult(index);
        query.setMaxResults(max);

        return query.getResultList();
    }

    @Override
    public List<Object[]> getTopProducts(int num) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        Root rootP = q.from(Product.class);
        Root rootD = q.from(OrderDetail.class);
        
        q.where(b.equal(rootP.get("id"), rootD.get("product")));
        q.multiselect(rootP.get("id"), 
                rootP.get("name"), 
                rootP.get("price"),
                rootP.get("image"), 
                b.sum(rootD.get("num")));
        
        q.groupBy(rootP.get("id"));
        q.orderBy(b.desc(b.sum(rootD.get("num"))));
        
        
        Query query = session.createQuery(q);
        query.setMaxResults(num);
        List<Object[]> results = query.getResultList();
        
        return results;
    }

    @Override
    public Product getProductById(int productId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        return session.get(Product.class, productId);
    }

}
