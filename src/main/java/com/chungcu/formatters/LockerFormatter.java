/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.formatters;

import com.chungcu.pojo.Apartment;
import com.chungcu.pojo.Locker;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author tien
 */
public class LockerFormatter implements Formatter<Locker>{
    @Override
    public String print(Locker locker, Locale locale) {
        return String.valueOf(locker.getId());
    }

    @Override
    public Locker parse(String lockerId, Locale locale) throws ParseException {
        int id = Integer.parseInt(lockerId);
        return new Locker(id);
    }
}
