/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.formatters;

import com.chungcu.pojo.Bill;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author tien
 */
public class BillFormatter implements Formatter<Bill>{
    @Override
    public String print(Bill bill, Locale locale) {
        return String.valueOf(bill.getId());
    }

    @Override
    public Bill parse(String billId, Locale locale) throws ParseException {
        int id = Integer.parseInt(billId);
        return new Bill(id);
    }
}
