/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.chungcu.services;

import com.chungcu.pojo.Apartment;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tien
 */
public interface ApartmentService {
    List<Apartment> getApartments(Map<String, String> params);
    boolean addOrUpdateApartment(Apartment apartment);
    List<Apartment> findAllApartmentsWithStatus();
    List<Apartment> findAvailableApartments();
    boolean deleteApartment(int apartmentId);
}
