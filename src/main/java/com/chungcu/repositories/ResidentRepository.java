/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.chungcu.repositories;

import com.chungcu.pojo.Resident;
import java.util.List;


/**
 *
 * @author tien
 */
public interface ResidentRepository {
    int addResident(Resident resident);
    List<Object[]> getAllResident();
}
