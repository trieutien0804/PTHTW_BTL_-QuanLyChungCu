/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.services.impl;

import com.chungcu.pojo.Locker;
import com.chungcu.repositories.LockerRepository;
import com.chungcu.services.LockerService;
import java.util.List;
import java.util.Map;
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
    public List<Locker> getAllLocker(Map<String, String> params) {
        return this.lockerRepo.getAllLocker(params);
    }

    @Override
    public int countLocker(Map<String, String> params) {
        return this.lockerRepo.countLocker(params);
    }

    @Override
    public boolean addOrUpdateLocker(Locker locker) {
        return this.lockerRepo.addOrUpdateLocker(locker);

    }

    @Override
    public boolean deleteLocker(int lockerId) {
        return this.lockerRepo.deleteLocker(lockerId);
    }

    @Override
    public Locker getLockerById(int id) {
        return this.lockerRepo.getLockerById(id);
    }
    
}
