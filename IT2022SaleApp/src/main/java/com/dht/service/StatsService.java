/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.service;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface StatsService {
    List<Object[]> cateStats();
    List<Object[]> getRevenueByProduct(String kw, Date fromDate, Date toDate);
    List<Object[]> getRevenueByMonth(int year);
    List<Object[]> getRevenueByQuarter(int year);
}
