/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.chungcu.repositories;

import com.chungcu.pojo.Bill;
import java.util.List;

/**
 *
 * @author tien
 */
public interface BillRepository {
     List<Bill> getAllBill();
     boolean addOrUpdate(Bill bill);
}
