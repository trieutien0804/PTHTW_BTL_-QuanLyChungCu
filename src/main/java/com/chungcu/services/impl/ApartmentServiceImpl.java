/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.services.impl;

import com.chungcu.pojo.Apartment;
import com.chungcu.repositories.ApartmentRepository;
import com.chungcu.services.ApartmentService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author tien
 */
@Service
public class ApartmentServiceImpl implements ApartmentService {

    @Autowired
    private ApartmentRepository apartmentRepo;

    @Override
    public List<Apartment> getApartments() {
        return this.apartmentRepo.getApartments();
    }

    @Override
    public boolean addOrUpdateApartment(Apartment apartment) {
        return this.apartmentRepo.addOrUpdateApartment(apartment);
    }

    @Override
    public List<Apartment> findAllApartmentsWithStatus() {
        return this.apartmentRepo.findAllApartmentsWithStatus();
    }

    @Override
    public List<Apartment> findAvailableApartments() {
        List<Apartment> apartments = this.apartmentRepo.findAllApartmentsWithStatus(); // Gọi phương thức đã có
        return apartments.stream()
                .filter(apartment -> apartment.getStatus().equals("Còn trống")) // Lọc theo trạng thái
                .collect(Collectors.toList());
    }

}
