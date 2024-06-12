/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.services.impl;

import com.chungcu.pojo.Locker;
import com.chungcu.repositories.LockerRepository;
import com.chungcu.services.LockerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tien
 */
@Service
public class LockerServiceImpl implements LockerService{
    
    @Autowired
    private LockerRepository lockerRepo;
    
    @Override
    public List<Locker> getAllLocker() {
        return this.lockerRepo.getALlLocker();
    }
    
}
