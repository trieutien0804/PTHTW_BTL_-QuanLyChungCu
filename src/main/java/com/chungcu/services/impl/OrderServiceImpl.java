/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.services.impl;

import com.chungcu.pojo.Order1;
import com.chungcu.repositories.OrderRepository;
import org.springframework.stereotype.Service;
import com.chungcu.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 * @author ptdzu
 */
@Service
public class OrderServiceImpl implements OrderService{
    
    @Autowired
    private OrderRepository orderRepo;
    

    @Override
    public boolean addOrder(Order1 order) {
        return this.orderRepo.addOrder(order);    
    }

    @Override
    public boolean addOrUpdateOrder(Order1 order) {
        return this.orderRepo.addOrUpdateOrder(order);  
    }
    }
