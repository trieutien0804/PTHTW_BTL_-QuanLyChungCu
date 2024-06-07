/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.formatters;

import com.chungcu.pojo.Apartment;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author tien
 */
public class ApartmentFormatter implements Formatter<Apartment>{

    @Override
    public String print(Apartment apartment, Locale locale) {
        return String.valueOf(apartment.getId());
    }

    @Override
    public Apartment parse(String apartmentId, Locale locale) throws ParseException {
        int id = Integer.parseInt(apartmentId);
        return new Apartment(id);
    }
    
}
