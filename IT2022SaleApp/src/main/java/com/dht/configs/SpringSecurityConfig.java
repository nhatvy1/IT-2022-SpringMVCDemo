/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Admin
 */
@Configuration
public class SpringSecurityConfig {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder b = new BCryptPasswordEncoder();
        
        return b;
    }
}
