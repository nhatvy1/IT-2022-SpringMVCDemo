/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.service.impl;

import com.dht.repository.StatsRepository;
import com.dht.service.StatsService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class StatsServiceImpl implements StatsService {
    @Autowired
    private StatsRepository statsRepository;
    
    @Override
    public List<Object[]> cateStats() {
        return this.statsRepository.cateStats();
    }

    @Override
    public List<Object[]> getRevenueByProduct(String kw, Date fromDate, Date toDate) {
        return this.statsRepository.getRevenueByProduct(kw, fromDate, toDate);
    }

    @Override
    public List<Object[]> getRevenueByMonth(int year) {
        return this.statsRepository.getRevenueByMonth(year);
    }

    @Override
    public List<Object[]> getRevenueByQuarter(int year) {
        return this.statsRepository.getRevenueByQuarter(year);
    }
    
}
