/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.services.impl;

import com.chungcu.pojo.Resident;
import com.chungcu.repositories.ResidentRepository;
import com.chungcu.services.ResidentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tien
 */
@Service
public class ResidentServiceImpl implements ResidentService{

    @Autowired
    private ResidentRepository residentRepo;
    
    @Override
    public List<Object[]> getAllResident() {
        return this.residentRepo.getAllResident();
    }
    
}
