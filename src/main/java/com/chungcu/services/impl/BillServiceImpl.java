/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.services.impl;

import com.chungcu.pojo.Bill;
import com.chungcu.repositories.BillRepository;
import com.chungcu.services.BillService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tien
 */
@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillRepository billRepo;

    @Override
    public List<Bill> getALlBill(Map<String, String> params) {
        return this.billRepo.getAllBill(params);
    }

    @Override
    public boolean addOrUpdateBill(Bill bill) {
        return this.billRepo.addOrUpdateBill(bill);
    }
    @Override
    public Bill getBillById(int id){
        return this.billRepo.getBillById(id);
    }

    @Override
    public int countBill(Map<String, String> params) {
        return this.billRepo.countBill(params);
    
    }

    @Override
    public boolean deleteBill(int billId) {
        return this.billRepo.deleteBill(billId);
    }

    @Override
    public List<Bill> getBills() {
        return this.billRepo.getBills();
    }

    @Override
    public List<Bill> getBillsOfResident(int residentId) {
        return this.billRepo.getBillsOfResident(residentId);
    }
}
