/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.service;

import com.dht.hibernatedemo.HibernateUtils;
import com.dht.pojo.Category;
import com.dht.pojo.OrderDetail;
import com.dht.pojo.Product;
import com.dht.pojo.SaleOrder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Admin
 */
public class StatsService {

    private static final SessionFactory factory = HibernateUtils.getSessionFactory();

    // Thong ke so so luong san pham theo danh muc
    public List<Object[]> cateStats() {
        try (Session session = factory.openSession()) {
            CriteriaBuilder b = session.getCriteriaBuilder();
            CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

            Root rootC = q.from(Category.class);
            Root rootP = q.from(Product.class);

            q.where(b.equal(rootP.get("category"), rootC.get("id")));
            q.multiselect(rootC.get("id"), rootC.get("name"), b.count(rootP.get("id")));
            q.groupBy(rootC.get("id"));

            Query query = session.createQuery(q);

            return query.getResultList();
        }
    }

    // Thong ke doanh thu theo tung san pham, cho phep loc theo ten san pham, ngay thang ban
    public List<Object[]> getRevenueByProduct(String kw, Date fromDate, Date toDate) {
        try (Session session = factory.openSession()) {
            CriteriaBuilder b = session.getCriteriaBuilder();
            CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

            Root rootP = q.from(Product.class);
            Root rootD = q.from(OrderDetail.class);
            Root rootO = q.from(SaleOrder.class);

            List<Predicate> pre = new ArrayList<>();
            pre.add(b.equal(rootD.get("product"), rootP.get("id")));
            pre.add(b.equal(rootD.get("order"), rootO.get("id")));

            if (kw != null && !kw.isEmpty()) {
                pre.add(b.like(rootP.get("name").as(String.class), String.format("%%%s%%", kw)));
            }

            if (fromDate != null) {
                pre.add(b.greaterThanOrEqualTo(rootO.get("createdDate").as(Date.class), fromDate));
            }

            if (toDate != null) {
                pre.add(b.lessThanOrEqualTo(rootO.get("createdDate").as(Date.class), toDate));
            }

            q.where(pre.toArray(new Predicate[]{}));

            q.multiselect(rootP.get("id"), rootP.get("name"), rootP.get("price"),
                    b.sum(b.prod(rootD.get("unitPrice"), rootD.get("num"))));

            q.groupBy(rootP.get("id"));

            Query query = session.createQuery(q);

            return query.getResultList();
        }
    }

    // Thong ke doanh thu theo tung thang/nam va quy/nam
    public List<Object[]> getRevenueByMonth(int year) {
        try (Session session = factory.openSession()) {
            CriteriaBuilder b = session.getCriteriaBuilder();
            CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

            Root rootD = q.from(OrderDetail.class);
            Root rootO = q.from(SaleOrder.class);

            List<Predicate> pre = new ArrayList<>();
            pre.add(b.equal(rootD.get("order"), rootO.get("id")));
            pre.add(b.equal(b.function("YEAR", Integer.class, rootO.get("createdDate")), year));

            q.where(pre.toArray(new Predicate[]{}));

            q.multiselect(b.function("MONTH", Integer.class, rootO.get("createdDate")),
                    b.sum(b.prod(rootD.get("unitPrice"), rootD.get("num"))));

            q.groupBy(b.function("MONTH", Integer.class, rootO.get("createdDate")));

            Query query = session.createQuery(q);

            return query.getResultList();
        }
    }

    public List<Object[]> getRevenueByQuarter(int year) {
        try (Session session = factory.openSession()) {
            CriteriaBuilder b = session.getCriteriaBuilder();
            CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

            Root rootD = q.from(OrderDetail.class);
            Root rootO = q.from(SaleOrder.class);

            List<Predicate> pre = new ArrayList<>();
            pre.add(b.equal(rootD.get("order"), rootO.get("id")));
            pre.add(b.equal(b.function("YEAR", Integer.class, rootO.get("createdDate")), year));

            q.where(pre.toArray(new Predicate[]{}));

            q.multiselect(b.function("QUARTER", Integer.class, rootO.get("createdDate")),
                    b.sum(b.prod(rootD.get("unitPrice"), rootD.get("num"))));

            q.groupBy(b.function("QUARTER", Integer.class, rootO.get("createdDate")));
            
            q.orderBy(b.asc(b.function("QUARTER", Integer.class, rootO.get("createdDate"))));

            Query query = session.createQuery(q);

            return query.getResultList();
        }
    }
}
