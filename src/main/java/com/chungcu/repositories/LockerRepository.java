/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.chungcu.repositories;

import com.chungcu.pojo.Bill;
import com.chungcu.pojo.Locker;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tien
 */
public interface LockerRepository {
    boolean addLocker(Locker locker);
    List<Locker> getAllLocker(Map<String, String> params);
    int countLocker(Map<String, String> params);
    boolean addOrUpdateLocker(Locker locker);
    boolean deleteLocker(int lockerId);
    Locker getLockerById(int id);
}
