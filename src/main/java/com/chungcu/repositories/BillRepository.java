/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.chungcu.repositories;

import com.chungcu.pojo.Bill;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tien
 */
public interface BillRepository {
     List<Bill> getAllBill(Map<String, String> params);
     boolean addOrUpdateBill(Bill bill);
     Bill getBillById(int id);
     int countBill(Map<String, String> params);
     boolean deleteBill(int billId);
     List<Bill> getBills();
     List<Bill> getBillsOfResident(int residentId);
}
