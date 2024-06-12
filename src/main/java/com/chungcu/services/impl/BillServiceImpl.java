/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.services.impl;

import com.chungcu.pojo.Bill;
import com.chungcu.repositories.BillRepository;
import com.chungcu.services.BillService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tien
 */
@Service
public class BillServiceImpl implements BillService{
    
    @Autowired
    private BillRepository billRepo;

    @Override
    public List<Bill> getALlBill() {
        return this.billRepo.getAllBill();
    }
}