/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.controllers;

import com.dht.service.StatsService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
public class AdminController {

    @Autowired
    private StatsService statsService;

    @GetMapping("/admin/stats")
    public String stats(Model model,
            @RequestParam(name = "kw", defaultValue = "") String kw,
            @RequestParam(name = "fromDate", defaultValue = "") String fromDate,
            @RequestParam(name = "toDate", defaultValue = "") String toDate,
            @RequestParam(name = "year", defaultValue = "0") Integer year) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");

        Date fd = null, td = null;

        try {
            if (fromDate != null && !fromDate.isEmpty()) {
                fd = f.parse(fromDate);
            }
            if (toDate != null && !toDate.isEmpty()) {
                td = f.parse(toDate);
            }
        } catch (ParseException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Object[]> cates = this.statsService.cateStats();
        List<Object[]> revenueProducts = this.statsService.getRevenueByProduct(kw, fd, td);
        List<Object[]> revenueMonth = this.statsService.getRevenueByMonth(year);
        List<Object[]> revenueQuarter = this.statsService.getRevenueByQuarter(year);
        
        model.addAttribute("catesStats", cates);
        model.addAttribute("revenueProducts", revenueProducts);
        model.addAttribute("revenueMonth", revenueMonth);
        model.addAttribute("revenueQuarter", revenueQuarter);

        return "stats";
    }

}
