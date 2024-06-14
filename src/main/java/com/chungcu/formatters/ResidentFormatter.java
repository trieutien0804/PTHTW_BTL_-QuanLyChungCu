/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.formatters;

import com.chungcu.pojo.Resident;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author tien
 */
public class ResidentFormatter implements Formatter<Resident>{
        @Override
    public String print(Resident resident, Locale locale) {
        return String.valueOf(resident.getId());
    }

    @Override
    public Resident parse(String residentId, Locale locale) throws ParseException {
        int id = Integer.parseInt(residentId);
        return new Resident(id);
    }
}
