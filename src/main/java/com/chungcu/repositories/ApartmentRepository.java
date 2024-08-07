/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.chungcu.repositories;

import com.chungcu.pojo.Apartment;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tien
 */
public interface ApartmentRepository {
    List<Apartment> getApartments(Map<String, String> params);
    boolean addOrUpdateApartment(Apartment apartment);
    List<Apartment> findAllApartmentsWithStatus();
    boolean deleteApartment(int apartmentId);
    Apartment getApartmentById(int id);
    int countApartment(Map<String, String> params);
    boolean checkApartmentNumber(String apartmentNumber);
}
