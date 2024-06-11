/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.controllers;

import com.chungcu.pojo.Apartment;
import com.chungcu.services.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author tien
 */
@Controller
@RequestMapping("/admin")
public class ApartmentController {

    @Autowired
    private ApartmentService apartmentService;

//    @GetMapping("/apartment")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    public String createView(Model model) {
//        model.addAttribute("apartments", apartmentService.getApartments());
//        return "apartment";
//    }
    
    @GetMapping("/apartment")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String createView(Model model) {
        model.addAttribute("apartments", apartmentService.findAllApartmentsWithStatus());
        return "apartment";
    }

    @GetMapping("/addApartment")
    public String addApartmentView(Model model) {
        model.addAttribute("apartment", new Apartment());
        return "addApartment";
    }

    @PostMapping("/addApartment")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addApartment(@ModelAttribute(value = "apartment") Apartment apartment) {
        if (apartmentService.addOrUpdateApartment(apartment) == true)
            return "redirect:/admin/apartment";
        return "addApartment";
    }
}
