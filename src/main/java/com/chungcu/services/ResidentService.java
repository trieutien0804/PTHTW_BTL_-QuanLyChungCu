/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.services;

import com.chungcu.pojo.Resident;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tien
 */
public interface ResidentService {
    List<Object[]> getAllResident(Map<String, String> params);
    int countResident(Map<String, String> params);
    Resident getResidentByUserId(int userId);
}
